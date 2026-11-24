handleClearButton("clear-button", "clear-modal", "confirm-clear", "cancel-clear");

function handleClearButton(buttonId, modalId, confirmId, cancelId){
    const clearModal = document.getElementById(modalId);
    const button = document.getElementById(buttonId);
    const confirm = document.getElementById(confirmId);
    const cancel = document.getElementById(cancelId);

    button.addEventListener('click', (event) => {
        event.preventDefault();
        clearModal.classList.remove('hidden');
    })

    confirm.addEventListener('click', async (event) => {
        const response = await fetch('/statistics', {
            method: 'DELETE'
        });

        if (response.ok) {
            window.location.href = '/statistics';
        }
        clearModal.classList.add('hidden');
    })

    cancel.addEventListener('click', (event) => {
        clearModal.classList.add('hidden');
    })
}
