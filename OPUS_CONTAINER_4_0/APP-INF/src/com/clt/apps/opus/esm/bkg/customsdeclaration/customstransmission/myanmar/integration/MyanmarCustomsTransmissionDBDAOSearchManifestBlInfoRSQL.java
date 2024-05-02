/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MyanmarCustomsTransmissionDBDAOSearchManifestBlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MyanmarCustomsTransmissionDBDAOSearchManifestBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchManifestBlInfo
	  * </pre>
	  */
	public MyanmarCustomsTransmissionDBDAOSearchManifestBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration").append("\n"); 
		query.append("FileName : MyanmarCustomsTransmissionDBDAOSearchManifestBlInfoRSQL").append("\n"); 
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
		query.append("SELECT MEAS_QTY" ).append("\n"); 
		query.append("     , MEAS_UT_CD" ).append("\n"); 
		query.append("	 , PCK_QTY" ).append("\n"); 
		query.append("	 , (SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD = C.PCK_TP_CD) PCK_TP_CD" ).append("\n"); 
		query.append("	 , ACT_WGT" ).append("\n"); 
		query.append("	 , WGT_UT_CD" ).append("\n"); 
		query.append("	 , (SELECT SUM(OP_CNTR_QTY)" ).append("\n"); 
		query.append("		  FROM BKG_QUANTITY" ).append("\n"); 
		query.append("		 WHERE BKG_NO = @[bkg_no]) OP_CNTR_QTY" ).append("\n"); 
		query.append("     , TO_CHAR((SELECT OBL_ISS_DT" ).append("\n"); 
		query.append("                  FROM BKG_BL_ISS" ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no]),'YYYYMMDD') OBL_ISS_DT" ).append("\n"); 
		query.append("     , TO_CHAR((SELECT BL_OBRD_DT" ).append("\n"); 
		query.append("                  FROM BKG_BL_DOC" ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no]),'YYYYMMDD') BL_OBRD_DT" ).append("\n"); 
		query.append("FROM BKG_BL_DOC C" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}