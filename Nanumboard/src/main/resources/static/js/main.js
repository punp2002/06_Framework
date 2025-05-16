document.addEventListener('DOMContentLoaded', () => {
    const items = [
        { img: 'https://via.placeholder.com/300x200?text=액자', category: '나눔중', title: '예쁜 유리 액자 나눔합니다.' },
        { img: 'https://via.placeholder.com/300x200?text=텀블러', category: '나눔중', title: '텀블러 필요하신 분 나눔' },
        { img: 'https://via.placeholder.com/300x200?text=미니백', category: '나눔중', title: '미니백 나눔' },
        { img: 'https://via.placeholder.com/300x200?text=의자', category: '나눔중', title: '편안한 의자 나눔' },
        { img: 'https://via.placeholder.com/300x200?text=시계', category: '나눔중', title: '손목시계 나눔' },
        { img: 'https://via.placeholder.com/300x200?text=모자', category: '나눔중', title: '여름 모자 나눔' },
        { img: 'https://via.placeholder.com/300x200?text=장난감', category: '나눔중', title: '장난감 나눔' },
        { img: 'https://via.placeholder.com/300x200?text=점퍼', category: '나눔중', title: '스타일리시 점퍼 나눔' },
    ];

    const itemList = document.getElementById('itemList');

    items.forEach(item => {
        const itemDiv = document.createElement('div');
        itemDiv.className = 'item';
        itemDiv.innerHTML = `
            <img src="${item.img}" alt="${item.title}">
            <div class="info">
                <div class="category">${item.category}</div>
                <div class="title">${item.title}</div>
            </div>
        `;
        itemList.appendChild(itemDiv);
    });
});