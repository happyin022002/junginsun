/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchCustCmdtCntcInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.08.26 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchCustCmdtCntcInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCustCmdtCntcInfo
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchCustCmdtCntcInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchCustCmdtCntcInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG.OFC_CD                              OFC_CD" ).append("\n"); 
		query.append(", BKG.FAX_NO                              FAX_NO" ).append("\n"); 
		query.append(", BKG.CNTC_EML                            CNTC_EML" ).append("\n"); 
		query.append(", BKG.CNTC_RMK                            CNTC_RMK" ).append("\n"); 
		query.append(", TO_CHAR(BKG.UPD_DT, 'YYYY-MM-DD HH:MI') UPD_DT" ).append("\n"); 
		query.append(", BKG.CUST_CNT_CD                         CUST_CNT_CD" ).append("\n"); 
		query.append(", BKG.CUST_SEQ                            CUST_SEQ" ).append("\n"); 
		query.append(", BKG.CMDT_CNTC_SEQ                       CMDT_CNTC_SEQ" ).append("\n"); 
		query.append(", BKG.UPD_USR_ID                          UPD_USR_ID" ).append("\n"); 
		query.append(", USR.USR_NM                              USR_NM" ).append("\n"); 
		query.append("FROM BKG_IB_CMDT_CNTC     BKG" ).append("\n"); 
		query.append(", COM_USER             USR" ).append("\n"); 
		query.append("WHERE BKG.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND BKG.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND BKG.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND BKG.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND USR.USR_ID = BKG.UPD_USR_ID" ).append("\n"); 

	}
}