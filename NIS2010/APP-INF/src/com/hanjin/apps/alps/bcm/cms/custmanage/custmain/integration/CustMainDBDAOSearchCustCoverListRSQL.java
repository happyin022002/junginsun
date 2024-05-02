/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustMainDBDAOSearchCustCoverListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOSearchCustCoverListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Rep Search
	  * </pre>
	  */
	public CustMainDBDAOSearchCustCoverListRSQL(){
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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOSearchCustCoverListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(MC.SREP_CD,BCSR.SREP_CD,'Y','N') AS PRMRY_CHK_FLG" ).append("\n"); 
		query.append("       ,MSR.SREP_NM SREP_NM" ).append("\n"); 
		query.append("       ,BCSR.SREP_CD" ).append("\n"); 
		query.append("       ,MSR.SREP_STS_CD AS SREP_FLG" ).append("\n"); 
		query.append("       ,MSR.OFC_CD" ).append("\n"); 
		query.append("       ,MO.PRNT_OFC_CD" ).append("\n"); 
		query.append("       ,MSR.MPHN_NO INTL_MPHN_NO" ).append("\n"); 
		query.append("       ,MSR.SREP_EML" ).append("\n"); 
		query.append("       ,BCSR.DELT_FLG" ).append("\n"); 
		query.append("       ,BCSR.CUST_CNT_CD" ).append("\n"); 
		query.append("       ,BCSR.CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_CUST_SLS_REP BCSR" ).append("\n"); 
		query.append("     ,MDM_SLS_REP MSR" ).append("\n"); 
		query.append("     ,MDM_CUSTOMER MC" ).append("\n"); 
		query.append("     ,MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE BCSR.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND BCSR.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND BCSR.SREP_CD = MSR.SREP_CD" ).append("\n"); 
		query.append("AND BCSR.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND BCSR.CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("AND MSR.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND BCSR.DELT_FLG = 'N'" ).append("\n"); 

	}
}