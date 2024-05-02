/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchCaCgoSndIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.07.30 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchCaCgoSndIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoReleaseOrderDBDAOsearchCaCgoSndIdRSQL
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchCaCgoSndIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchCaCgoSndIdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	EDI_MSG_TP_ID AS EDI_MSG_ID," ).append("\n"); 
		query.append("	PRNR_SUB_LNK_CD AS EDI_YARD," ).append("\n"); 
		query.append("	SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("	RCVR_TRD_PRNR_ID AS EDI_RCV_ID," ).append("\n"); 
		query.append("	NVL(MSG.MSG_TP_DESC,'0') AS MSG_TP" ).append("\n"); 
		query.append("	FROM BKG_EDI_SUB_LNK_MSG MSG, " ).append("\n"); 
		query.append("		 BKG_EDI_TRD_PRNR_SUB_LNK LNK, " ).append("\n"); 
		query.append("		 BKG_BOOKING BK" ).append("\n"); 
		query.append("   WHERE MSG.EDI_MSG_TP_ID = 'TDC315'" ).append("\n"); 
		query.append("     AND MSG.EDI_MSG_IND_CD = 11" ).append("\n"); 
		query.append("     AND MSG.TRD_PRNR_SUB_LNK_SEQ = LNK.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("     AND BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("     AND BK.POD_NOD_CD = PRNR_SUB_LNK_CD" ).append("\n"); 
		query.append("--     AND EDI_SND_FLG ='N'" ).append("\n"); 

	}
}