/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchBlGroupCustomerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.01.13 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchBlGroupCustomerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select Group Customer
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchBlGroupCustomerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchBlGroupCustomerListRSQL").append("\n"); 
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
		query.append("    BL_GRP_SEQ," ).append("\n"); 
		query.append("	CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') AS OLD_CUST_CD," ).append("\n"); 
		query.append("    CUST_CNT_CD," ).append("\n"); 
		query.append("    CUST_SEQ," ).append("\n"); 
		query.append("    CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') AS CUST_CD," ).append("\n"); 
		query.append("    (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.CUST_CNT_CD AND CUST_SEQ = A.CUST_SEQ) AS CUST_NM," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CTRL_BL_GRP_CUST A" ).append("\n"); 
		query.append("WHERE BL_GRP_SEQ = @[bl_grp_seq]" ).append("\n"); 

	}
}