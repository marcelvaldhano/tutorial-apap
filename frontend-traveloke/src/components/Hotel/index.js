import React from "react";
import classes from "./styles.module.css";
import Button from "../../components/Button";


const Hotel = (props) => {
    const { id, namaHotel, alamat, nomorTelepon,handleEdit,handleDelete} = props;

// if(listKamar.length>0){
//     kamars=<div>
//         {listKamar.map((kamars)=>(
//             <Kamar
//                 id={kamar.noKamar}
//                 nama={kamar.namaKamar}

// />
//         ))}
//     </div>



// }else{
//     kamars=<p>Hotel tidak memiliki Kamar</p>
// }

return (
<div className={classes.hotel}>
    <h3>{`ID Hotel ${id}`}</h3>
    <p>{`Nama Hotel: ${namaHotel}`}</p>
    <p>{`Alamat: ${alamat}`}</p>
    <p>{`Nomor telepon: ${nomorTelepon}`}</p>

    {/* <div>
        {kamars}
    </div> */}

    <Button onClick={handleEdit} variant="success">
        Edit
    </Button>
    <Button onClick={handleDelete} variant="danger">
        Delete
    </Button>

 </div>
);
};
export default Hotel;
