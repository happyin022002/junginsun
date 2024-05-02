/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustMainDBDAOMergeMdmCustSezCertiUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.integration.DAO;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOMergeMdmCustSezCertiUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Merge MDM_CUST_SEZ_CERTI
	  * </pre>
	  */
	public CustMainDBDAOMergeMdmCustSezCertiUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_sav_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOMergeMdmCustSezCertiUSQL").append("\n"); 
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
		query.append("MERGE INTO MDM_CUST_SEZ_CERTI a										" ).append("\n"); 
		query.append(" USING ( select @[cust_cnt_cd] cust_cnt_cd, @[cust_seq] cust_seq, 1 FILE_SEQ from dual ) b           " ).append("\n"); 
		query.append(" ON (a.cust_cnt_cd = b.cust_cnt_cd and a.cust_seq = b.cust_seq and a.FILE_SEQ = b.FILE_SEQ)  " ).append("\n"); 
		query.append(" WHEN MATCHED THEN                                                " ).append("\n"); 
		query.append(" update                                                           " ).append("\n"); 
		query.append(" set      " ).append("\n"); 
		query.append("    FILE_SAV_ID = @[file_sav_id]" ).append("\n"); 
		query.append("    ,FILE_NM    = @[file_nm]" ).append("\n"); 
		query.append("    ,UPD_USR_ID = NVL(@[upd_usr_id], 'SYSTEM')" ).append("\n"); 
		query.append(" 	  ,UPD_DT     = sysdate" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN                                            " ).append("\n"); 
		query.append(" insert                                                           " ).append("\n"); 
		query.append(" (                                                                " ).append("\n"); 
		query.append("    CUST_CNT_CD, " ).append("\n"); 
		query.append("    CUST_SEQ, " ).append("\n"); 
		query.append("    FILE_SEQ," ).append("\n"); 
		query.append("    FILE_SAV_ID, " ).append("\n"); 
		query.append("    FILE_NM," ).append("\n"); 
		query.append("    CRE_USR_ID, " ).append("\n"); 
		query.append("    CRE_DT, " ).append("\n"); 
		query.append("    UPD_USR_ID, " ).append("\n"); 
		query.append("    UPD_DT	                                                 " ).append("\n"); 
		query.append(" )                                                                " ).append("\n"); 
		query.append(" values                                                           " ).append("\n"); 
		query.append(" (                                                                " ).append("\n"); 
		query.append(" 	@[cust_cnt_cd],                                              				" ).append("\n"); 
		query.append(" 	@[cust_seq],  " ).append("\n"); 
		query.append("  1," ).append("\n"); 
		query.append("  @[file_sav_id]," ).append("\n"); 
		query.append("  @[file_nm]," ).append("\n"); 
		query.append("  	NVL(@[cre_usr_id], 'SYSTEM')," ).append("\n"); 
		query.append(" 	NVL(to_date(@[cre_dt],'yyyymmddhh24miss'), sysdate)," ).append("\n"); 
		query.append(" 	NVL(@[upd_usr_id], 'SYSTEM')," ).append("\n"); 
		query.append(" 	NVL(to_date(@[upd_dt],'yyyymmddhh24miss'), sysdate)               			" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}