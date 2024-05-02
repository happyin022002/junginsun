/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOCreateRevenueAuditSurchargeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.28 
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

public class UnmatchBLDBDAOCreateRevenueAuditSurchargeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateRevenueAuditSurcharge
	  * </pre>
	  */
	public UnmatchBLDBDAOCreateRevenueAuditSurchargeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_hdn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_as_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oft_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frt_incl_xcld_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCreateRevenueAuditSurchargeCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_REV_AUD_CHG_TMP (" ).append("\n"); 
		query.append(" BKG_NO      " ).append("\n"); 
		query.append(",OFT_CMB_SEQ " ).append("\n"); 
		query.append(",CHG_RT_SEQ " ).append("\n"); 
		query.append(",CHG_CD      " ).append("\n"); 
		query.append(",RAT_UT_CD" ).append("\n"); 
		query.append(",CURR_CD     " ).append("\n"); 
		query.append(",CHG_UT_AMT  " ).append("\n"); 
		query.append(",RAT_AS_QTY " ).append("\n"); 
		query.append(",CHG_AMT " ).append("\n"); 
		query.append(",CGO_CATE_CD" ).append("\n"); 
		query.append(",RCV_TERM_CD " ).append("\n"); 
		query.append(",DE_TERM_CD" ).append("\n"); 
		query.append(",CRE_USR_ID  " ).append("\n"); 
		query.append(",CRE_DT      " ).append("\n"); 
		query.append(",UPD_USR_ID " ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",FRT_TERM_CD" ).append("\n"); 
		query.append(",FRT_INCL_XCLD_DIV_CD" ).append("\n"); 
		query.append(",PRN_HDN_FLG" ).append("\n"); 
		query.append(",IMDG_CLSS_CD" ).append("\n"); 
		query.append(") values (" ).append("\n"); 
		query.append(" @[bkg_no]      " ).append("\n"); 
		query.append(",@[oft_cmb_seq]" ).append("\n"); 
		query.append(",0" ).append("\n"); 
		query.append(",@[chg_cd]      " ).append("\n"); 
		query.append(",@[rat_ut_cd]" ).append("\n"); 
		query.append(",@[curr_cd]     " ).append("\n"); 
		query.append(",@[chg_ut_amt]  " ).append("\n"); 
		query.append(",@[rat_as_qty] " ).append("\n"); 
		query.append(",@[chg_amt] " ).append("\n"); 
		query.append(",@[cgo_tp_cd] -- CGO_CATE_CD <- CGO_TP_CD" ).append("\n"); 
		query.append(",@[rcv_term_cd] " ).append("\n"); 
		query.append(",@[de_term_cd]" ).append("\n"); 
		query.append(",@[usr_id]  " ).append("\n"); 
		query.append(",SYSDATE        " ).append("\n"); 
		query.append(",@[usr_id] " ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[frt_term_cd]" ).append("\n"); 
		query.append(",@[frt_incl_xcld_div_cd]" ).append("\n"); 
		query.append(",@[prn_hdn_flg]" ).append("\n"); 
		query.append(",@[imdg_clss_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}