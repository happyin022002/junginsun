/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOEmlBkgInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOEmlBkgInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOEmlBkgInfoVO
	  * </pre>
	  */
	public BLIssuanceDBDAOEmlBkgInfoVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOEmlBkgInfoVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("	BKG.BKG_NO" ).append("\n"); 
		query.append("	,BKG.BL_NO" ).append("\n"); 
		query.append("	,CUST.CUST_NM AS SHPR_NM" ).append("\n"); 
		query.append("	,VSL.VSL_ENG_NM||' '||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("	,POR.LOC_NM ||','||CNT_POR.CNT_NM  AS POR" ).append("\n"); 
		query.append("	,POD.LOC_NM ||','||CNT_POD.CNT_NM  AS POD" ).append("\n"); 
		query.append("	,TO_CHAR(DOC.BL_OBRD_DT, 'MON DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS BL_OBRD_DT" ).append("\n"); 
		query.append("	,CASE WHEN FINV.CUST_REF_NO_CTNT > ' ' THEN FINV.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("	      WHEN EBFF.CUST_REF_NO_CTNT > ' ' THEN EBFF.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("	 ELSE NVL(TRIM(BKG.SC_NO),BKG.RFA_NO) " ).append("\n"); 
		query.append("	 END AS REF_NO" ).append("\n"); 
		query.append("FROM   " ).append("\n"); 
		query.append("	BKG_BOOKING BKG" ).append("\n"); 
		query.append("	,BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("	,MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("	,MDM_LOCATION POR" ).append("\n"); 
		query.append("	,MDM_LOCATION POD" ).append("\n"); 
		query.append("	,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("	,MDM_COUNTRY CNT_POR" ).append("\n"); 
		query.append("	,MDM_COUNTRY CNT_POD" ).append("\n"); 
		query.append("	,BKG_REFERENCE FINV" ).append("\n"); 
		query.append("	,BKG_REFERENCE EBFF" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUST.BKG_NO(+)" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("AND BKG.VSL_CD = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("AND BKG.POR_CD = POR.LOC_CD(+)" ).append("\n"); 
		query.append("AND BKG.POD_CD = POD.LOC_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("AND POR.CNT_CD = CNT_POR.CNT_CD(+)" ).append("\n"); 
		query.append("AND POD.CNT_CD = CNT_POD.CNT_CD(+) " ).append("\n"); 
		query.append("AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG.BKG_NO = FINV.BKG_NO(+)" ).append("\n"); 
		query.append("AND FINV.BKG_REF_TP_CD(+) ='FINV'" ).append("\n"); 
		query.append("AND BKG.BKG_NO = EBFF.BKG_NO(+)" ).append("\n"); 
		query.append("AND EBFF.BKG_REF_TP_CD(+) ='EBFF'" ).append("\n"); 

	}
}