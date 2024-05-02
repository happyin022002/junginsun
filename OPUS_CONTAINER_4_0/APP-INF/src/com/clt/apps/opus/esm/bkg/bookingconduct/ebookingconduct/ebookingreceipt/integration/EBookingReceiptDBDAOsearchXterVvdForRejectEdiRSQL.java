/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterVvdForRejectEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.05.21 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterVvdForRejectEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterVvdForRejectEdi
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterVvdForRejectEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterVvdForRejectEdiRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("select " ).append("\n"); 
		query.append("    mst.VSL_CD				    vvdcode          " ).append("\n"); 
		query.append("    , VSL.LLOYD_NO 				vvdloyd          " ).append("\n"); 
		query.append("    , mst.Vsl_NM				vvdvslname       " ).append("\n"); 
		query.append("    , NULL						vvdvsl_call_sign " ).append("\n"); 
		query.append("    , mst.SKD_VOY_NO			vvdvoy           " ).append("\n"); 
		query.append("    , mst.SKD_DIR_CD			vvddir           " ).append("\n"); 
		query.append("    , mst.POL_CD				vvdpolunlc       " ).append("\n"); 
		query.append("    , mst.POL_NM				vvdpolname       " ).append("\n"); 
		query.append("    , mst.POD_CD				vvdpodunlc       " ).append("\n"); 
		query.append("    , mst.POD_NM				vvdpodname       " ).append("\n"); 
		query.append("    , NULL						ref1vvdvoy       " ).append("\n"); 
		query.append("    , NVL(TO_CHAR(VVD1.VPS_ETA_DT, 'YYYYMMDDHH24MISS'), ' ')	vvdpoleta        " ).append("\n"); 
		query.append("    , NVL(TO_CHAR(VVD1.VPS_ETD_DT, 'YYYYMMDDHH24MISS'), ' ')	vvdpoletd        " ).append("\n"); 
		query.append("    , NVL(TO_CHAR(VVD2.VPS_ETA_DT, 'YYYYMMDDHH24MISS'), ' ')	vvdpodeta   " ).append("\n"); 
		query.append("  FROM bkg_xter_rqst_mst mst, vsk_VSL_PORT_SKD VVD1, vsk_VSL_PORT_SKD VVD2, MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append(" where mst.xter_sndr_id = @[sender_id]" ).append("\n"); 
		query.append("   and mst.xter_rqst_no = @[rqst_no]" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq= @[rqst_seq]" ).append("\n"); 
		query.append("   and mst.vsl_cd       = VVD1.vsl_cd       (+)" ).append("\n"); 
		query.append("   and mst.skd_voy_no   = VVD1.skd_voy_no   (+)" ).append("\n"); 
		query.append("   and mst.skd_dir_cd   = VVD1.skd_dir_cd   (+)" ).append("\n"); 
		query.append("   and mst.poL_cd       = VVD1.vps_port_cd  (+)   " ).append("\n"); 
		query.append("   AND mst.VSL_CD       = VVD2.VSL_CD       (+)" ).append("\n"); 
		query.append("   AND mst.SKD_VOY_NO   = VVD2.SKD_VOY_NO   (+)" ).append("\n"); 
		query.append("   AND mst.SKD_DIR_CD   = VVD2.SKD_DIR_CD   (+)" ).append("\n"); 
		query.append("   AND mst.POD_CD       = VVD2.vps_port_cd  (+)" ).append("\n"); 
		query.append("   AND mst.VSL_CD	= VSL.VSL_CD        (+)" ).append("\n"); 
		query.append("   and rownum           = 1" ).append("\n"); 

	}
}