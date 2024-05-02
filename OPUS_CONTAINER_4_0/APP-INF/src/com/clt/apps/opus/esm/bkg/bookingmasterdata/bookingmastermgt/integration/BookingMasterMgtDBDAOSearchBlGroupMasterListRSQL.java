/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchBlGroupMasterListRSQL.java
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

public class BookingMasterMgtDBDAOSearchBlGroupMasterListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select BKG_CTRL_BL_GRP List
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchBlGroupMasterListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_grp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchBlGroupMasterListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    BL_GRP_SEQ," ).append("\n"); 
		query.append("    BL_GRP_NM," ).append("\n"); 
		query.append("    BL_GRP_DESC," ).append("\n"); 
		query.append("	CRE_USR_ID," ).append("\n"); 
		query.append("	CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CTRL_BL_GRP CTRL" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${bl_grp_nm} != '')" ).append("\n"); 
		query.append("AND UPPER(BL_GRP_NM) LIKE '%'||UPPER(@[bl_grp_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_grp_desc} != '')" ).append("\n"); 
		query.append("AND UPPER(BL_GRP_DESC) LIKE '%'||UPPER(@[bl_grp_desc])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '' && ${cust_seq} != '')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append(" FROM BKG_CTRL_BL_GRP_CUST CUST " ).append("\n"); 
		query.append(" WHERE CTRL.BL_GRP_SEQ = CUST.BL_GRP_SEQ " ).append("\n"); 
		query.append(" AND CUST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append(" AND CUST.CUST_SEQ = @[cust_seq]) " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}