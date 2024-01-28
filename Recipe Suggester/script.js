document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('recipeForm');
    const recipeResults = document.getElementById('recipeResults');

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent form submission

        // Clear previous results
        recipeResults.innerHTML = '';

        // Get input value
        const ingredientsInput = document.getElementById('ingredients');
        const ingredients = ingredientsInput.value.trim();

        // Check if input is empty
        if (ingredients === '') {
            showMessage('Please enter ingredients');
            return;
        }

        // Split input into array of ingredients
        const ingredientList = ingredients.split(',');

        // Display loading message
        showMessage('Fetching recipes...');

        // Call function to fetch recipes
        fetchRecipes(ingredientList);
    });

    function fetchRecipes(ingredients) {
        // Here you would make an API request to fetch recipes based on the ingredients
        // For demonstration purposes, we'll simulate fetching data with a delay
        setTimeout(function() {
            // Simulated data (replace with actual API call)
            const recipes = [
                { name: 'Pasta with Tomato Sauce', ingredients: ['pasta', 'tomato sauce', 'garlic', 'olive oil'] },
                { name: 'Vegetable Stir Fry', ingredients: ['vegetables', 'soy sauce', 'garlic', 'ginger'] },
                { name: 'Chicken Caesar Salad', ingredients: ['chicken', 'lettuce', 'caesar dressing', 'parmesan cheese'] }
            ];

            // Display recipes
            displayRecipes(recipes);
        }, 1500); // Simulate delay of 1.5 seconds
    }

    function displayRecipes(recipes) {
        // Clear loading message
        recipeResults.innerHTML = '';

        if (recipes.length === 0) {
            showMessage('No recipes found');
            return;
        }

        // Create and append recipe cards
        recipes.forEach(function(recipe) {
            const recipeCard = document.createElement('div');
            recipeCard.classList.add('recipe-card');
            recipeCard.innerHTML = `
                <h3>${recipe.name}</h3>
                <p><strong>Ingredients:</strong> ${recipe.ingredients.join(', ')}</p>
            `;
            recipeResults.appendChild(recipeCard);
        });
    }

    function showMessage(message) {
        const messageElement = document.createElement('div');
        messageElement.classList.add('message');
        messageElement.textContent = message;
        recipeResults.appendChild(messageElement);
    }
});