/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingMasterMgtDBDAORemoveBlGroupCustomerDSQL.java
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

public class BookingMasterMgtDBDAORemoveBlGroupCustomerDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * delete bl group customer
	  * </pre>
	  */
	public BookingMasterMgtDBDAORemoveBlGroupCustomerDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAORemoveBlGroupCustomerDSQL").append("\n"); 
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
		query.append("DELETE BKG_CTRL_BL_GRP_CUST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${bl_grp_seq} != '' )" ).append("\n"); 
		query.append("AND BL_GRP_SEQ  = @[bl_grp_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cd} != '' )" ).append("\n"); 
		query.append("AND CUST_CNT_CD = SUBSTR(@[old_cust_cd],0,2)" ).append("\n"); 
		query.append("AND CUST_SEQ    = SUBSTR(@[old_cust_cd],3,6)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}