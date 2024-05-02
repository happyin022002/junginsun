/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingMasterMgtDBDAOcheckEcomUsrInfoForBlGrpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOcheckEcomUsrInfoForBlGrpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check the customer is still included in BL Group in ECOM
	  * </pre>
	  */
	public BookingMasterMgtDBDAOcheckEcomUsrInfoForBlGrpRSQL(){
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
		params.put("bl_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration ").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOcheckEcomUsrInfoForBlGrpRSQL").append("\n"); 
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
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (SELECT 1 " ).append("\n"); 
		query.append("                FROM BKG_XTER_USR_INFO" ).append("\n"); 
		query.append("               WHERE 1=1" ).append("\n"); 
		query.append("                 AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                 AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                 AND BL_GRP_SEQ = @[bl_grp_seq])" ).append("\n"); 

	}
}