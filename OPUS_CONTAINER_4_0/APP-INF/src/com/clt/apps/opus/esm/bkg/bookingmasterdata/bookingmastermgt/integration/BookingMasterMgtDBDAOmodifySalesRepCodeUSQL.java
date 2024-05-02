/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingMasterMgtDBDAOmodifySalesRepCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.22
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.07.22 박찬민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK CHAN MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOmodifySalesRepCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifySalesRepCode
	  * </pre>
	  */
	public BookingMasterMgtDBDAOmodifySalesRepCodeUSQL(){
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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOmodifySalesRepCodeUSQL").append("\n"); 
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
		query.append("#if (${op_cd} == 'U')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE BKG_CUST_SLS_REP" ).append("\n"); 
		query.append("	SET DP_SEQ = '0'," ).append("\n"); 
		query.append("		DELT_FLG = 'N', " ).append("\n"); 
		query.append("		SREP_CUST_CLSS_CD =  'C', " ).append("\n"); 
		query.append("		UPD_USR_ID =  @[user_id]," ).append("\n"); 
		query.append("		UPD_DT =  SYSDATE" ).append("\n"); 
		query.append("	WHERE SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("	  AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	  AND CUST_SEQ = @[cust_seq] 	 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${op_cd} == 'D')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE BKG_CUST_SLS_REP" ).append("\n"); 
		query.append("	SET DELT_FLG = 'Y'," ).append("\n"); 
		query.append("	    UPD_USR_ID = @[user_id]," ).append("\n"); 
		query.append("		UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	WHERE SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("	  AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	  AND CUST_SEQ = @[cust_seq] 	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}