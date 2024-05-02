/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UnmatchBLDBDAOManageMultiRateBkgList1USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOManageMultiRateBkgList1USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Rate BKG List for Audit(1) 수정
	  * </pre>
	  */
	public UnmatchBLDBDAOManageMultiRateBkgList1USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("usr_ins_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_upd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOManageMultiRateBkgList1USQL").append("\n"); 
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
		query.append("UPDATE	BKG_REV_OCN_FRT_MLT_RAT_USR" ).append("\n"); 
		query.append("SET		UPD_DT = SYSDATE" ).append("\n"); 
		query.append("		,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("#if (${btn} == 'SAVE')" ).append("\n"); 
		query.append("		,USR_UPD_CTNT = @[usr_upd_ctnt]" ).append("\n"); 
		query.append("		,USR_INS_AMT = @[usr_ins_amt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${btn} == 'CONFIRM')" ).append("\n"); 
		query.append("		,USR_UPD_CTNT = @[usr_upd_ctnt]" ).append("\n"); 
		query.append("		,USR_INS_AMT = @[usr_ins_amt]" ).append("\n"); 
		query.append("		,CFM_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("		,CFM_DT = SYSDATE" ).append("\n"); 
		query.append("		,USR_UPD_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${btn} == 'RELEASE')" ).append("\n"); 
		query.append("		,CFM_USR_ID = NULL" ).append("\n"); 
		query.append("		,CFM_DT = NULL" ).append("\n"); 
		query.append("		,USR_UPD_CFM_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}