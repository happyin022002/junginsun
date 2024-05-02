/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOmodifyOblByUsCgoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2010.04.08 박성호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Sungho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOmodifyOblByUsCgoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOmodifyOblByUsCgoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_otr_doc_rcv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rdem_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOmodifyOblByUsCgoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BL_ISS" ).append("\n"); 
		query.append("   SET OBL_RDEM_FLG       = CASE WHEN (TO_NUMBER(@[obl_rdem_knt]) > 0 AND NVL(LENGTH(@[bl_otr_doc_rcv_cd]),0) = 2 ) THEN 'Y' ELSE 'N' END," ).append("\n"); 
		query.append("       OBL_RDEM_KNT       = DECODE(NVL(@[obl_rdem_knt],0),0,NULL," ).append("\n"); 
		query.append("                                DECODE(@[obl_rdem_knt],OBL_RDEM_KNT,OBL_RDEM_KNT,@[obl_rdem_knt]))," ).append("\n"); 
		query.append("       OBL_RDEM_OFC_CD    = DECODE(NVL(@[obl_rdem_knt],0),0,NULL," ).append("\n"); 
		query.append("                                DECODE(@[obl_rdem_knt],OBL_RDEM_KNT,OBL_RDEM_OFC_CD,@[ofc_cd]))," ).append("\n"); 
		query.append("       OBL_RDEM_USR_ID    = DECODE(NVL(@[obl_rdem_knt],0),0,NULL," ).append("\n"); 
		query.append("                                DECODE(@[obl_rdem_knt],OBL_RDEM_KNT,OBL_RDEM_USR_ID,@[usr_id]))," ).append("\n"); 
		query.append("       OBL_RDEM_DT        = TO_DATE(DECODE(NVL(@[obl_rdem_knt],0),0,NULL," ).append("\n"); 
		query.append("                                    DECODE(@[obl_rdem_knt],OBL_RDEM_KNT,TO_CHAR(OBL_RDEM_DT,'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("                                                                        TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,BKG_COM_USER_LOC_FNC(@[usr_id])),'YYYYMMDDHH24MISS')))," ).append("\n"); 
		query.append("                            'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("       BL_OTR_DOC_RCV_CD  = DECODE(@[bl_otr_doc_rcv_cd],NULL,NULL," ).append("\n"); 
		query.append("                            DECODE(@[bl_otr_doc_rcv_cd],BL_OTR_DOC_RCV_CD,BL_OTR_DOC_RCV_CD,@[bl_otr_doc_rcv_cd]))," ).append("\n"); 
		query.append("       OTR_DOC_RCV_OFC_CD = DECODE(@[bl_otr_doc_rcv_cd],NULL,NULL," ).append("\n"); 
		query.append("                            DECODE(@[bl_otr_doc_rcv_cd],BL_OTR_DOC_RCV_CD,OTR_DOC_RCV_OFC_CD,@[ofc_cd]))," ).append("\n"); 
		query.append("       OTR_DOC_RCV_USR_ID = DECODE(@[bl_otr_doc_rcv_cd],NULL,NULL," ).append("\n"); 
		query.append("                            DECODE(@[bl_otr_doc_rcv_cd],BL_OTR_DOC_RCV_CD,OTR_DOC_RCV_USR_ID,@[usr_id]))," ).append("\n"); 
		query.append("       OTR_DOC_RCV_DT     = TO_DATE(DECODE(@[bl_otr_doc_rcv_cd],NULL,NULL," ).append("\n"); 
		query.append("                                    DECODE(@[bl_otr_doc_rcv_cd],BL_OTR_DOC_RCV_CD,TO_CHAR(OTR_DOC_RCV_DT,'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("                                                                                  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,BKG_COM_USER_LOC_FNC(@[usr_id])),'YYYYMMDDHH24MISS')))," ).append("\n"); 
		query.append("                            'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}