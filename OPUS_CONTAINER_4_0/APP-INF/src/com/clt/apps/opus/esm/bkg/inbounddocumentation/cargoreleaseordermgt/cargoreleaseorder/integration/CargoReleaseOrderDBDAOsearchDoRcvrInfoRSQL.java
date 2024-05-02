/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchDoRcvrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchDoRcvrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDoRcvrInfo
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchDoRcvrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchDoRcvrInfoRSQL").append("\n"); 
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
		query.append("SELECT BKDO.BKG_NO                                 BKG_NO" ).append("\n"); 
		query.append("     , BKDO.RLSE_SEQ                               RLSE_SEQ	" ).append("\n"); 
		query.append("     , BKDO.DO_NO || BKDO.DO_NO_SPLIT              DO_NO	" ).append("\n"); 
		query.append("	 , BKDO.RCVR_CO_NM                             RCVR_CO_NM" ).append("\n"); 
		query.append("	 , BKDO.RCVR_PHN_NO                            CNTC_PHN_NO" ).append("\n"); 
		query.append("	 , BKDO.PIC_NM                                 PIC" ).append("\n"); 
		query.append("	 , REPLACE(substr(NVL(BKDO.RCVR_CNEE_NM,BCST.CUST_NM), 1, 48),'')        ACT_CNEE_NM" ).append("\n"); 
		query.append("     , BKDO.RCVR_BIZ_NO                            CUST_REF_NM" ).append("\n"); 
		query.append("	 , DECODE(BKGM.CUST_TO_ORD_FLG,'Y','YES','NO') ORDER_FLG" ).append("\n"); 
		query.append("  FROM BKG_DO BKDO	" ).append("\n"); 
		query.append("     , BKG_BOOKING BKGM	" ).append("\n"); 
		query.append("     , BKG_CUSTOMER BCST	" ).append("\n"); 
		query.append(" WHERE BKDO.DO_NO = SUBSTR(@[do_no],1,10)	" ).append("\n"); 
		query.append("   AND BKDO.DO_NO_SPLIT = NVL(SUBSTR(@[do_no],11,2),'00')	" ).append("\n"); 
		query.append("   AND BKGM.BKG_NO = BKDO.BKG_NO	" ).append("\n"); 
		query.append("   AND BCST.BKG_NO = BKGM.BKG_NO	" ).append("\n"); 
		query.append("   AND BCST.BKG_CUST_TP_CD IN DECODE (BKGM.CUST_TO_ORD_FLG,'Y', 'N', 'C')" ).append("\n"); 

	}
}