/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOInsertEDIBkgEppCntrWithoutCycNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOInsertEDIBkgEppCntrWithoutCycNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsertEDIBkgEppCntrWithoutCycNo
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOInsertEDIBkgEppCntrWithoutCycNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration ").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOInsertEDIBkgEppCntrWithoutCycNoCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_BKG_CNTR" ).append("\n"); 
		query.append("			(BKG_NO			," ).append("\n"); 
		query.append("			CNTR_NO			," ).append("\n"); 
		query.append("			CNTR_TPSZ_CD	," ).append("\n"); 
		query.append("			CNMV_YR			," ).append("\n"); 
		query.append("			CNMV_ID_NO		," ).append("\n"); 
		query.append("			CNMV_CYC_NO		," ).append("\n"); 
		query.append("			CNMV_STS_CD		," ).append("\n"); 
		query.append("			RCV_TERM_CD		," ).append("\n"); 
		query.append("			DE_TERM_CD		," ).append("\n"); 
		query.append("			CNTR_VOL_QTY	," ).append("\n"); 
		query.append("			DCGO_FLG		," ).append("\n"); 
		query.append("			RC_FLG			," ).append("\n"); 
		query.append("			BB_CGO_FLG		," ).append("\n"); 
		query.append("			AWK_CGO_FLG		," ).append("\n"); 
		query.append("			RD_CGO_FLG		," ).append("\n"); 
		query.append("			HNGR_FLG		," ).append("\n"); 
		query.append("			SOC_FLG			," ).append("\n"); 
		query.append("			CNMV_EVNT_DT	," ).append("\n"); 
		query.append("			CNTR_CFM_FLG	," ).append("\n"); 
		query.append("			CRE_USR_ID		," ).append("\n"); 
		query.append("			CRE_DT			," ).append("\n"); 
		query.append("			UPD_USR_ID		," ).append("\n"); 
		query.append("			UPD_DT			," ).append("\n"); 
		query.append("            OSCA_CRE_DT     ," ).append("\n"); 
		query.append("            OSCA_UPD_DT" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("     VALUES " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("			@[bkg_no]			," ).append("\n"); 
		query.append("			@[cntr_no]			," ).append("\n"); 
		query.append("			DECODE(@[cntr_tpsz_cd], '20GP','D2'," ).append("\n"); 
		query.append("									'40GP','D4'," ).append("\n"); 
		query.append("									'40HQ','D5'," ).append("\n"); 
		query.append("									'45HQ','D7'," ).append("\n"); 
		query.append("									'20FL','F2'," ).append("\n"); 
		query.append("									'40FL','F4'," ).append("\n"); 
		query.append("									'20OT','O2'," ).append("\n"); 
		query.append("									'40OT','O4'," ).append("\n"); 
		query.append("									'20RF','R2'," ).append("\n"); 
		query.append("									'40RQ','R5'," ).append("\n"); 
		query.append("									'20TK','T2'," ).append("\n"); 
		query.append("									'40TK','T4',@[cntr_tpsz_cd]) ," ).append("\n"); 
		query.append("			@[cnmv_yr]	," ).append("\n"); 
		query.append("			@[cnmv_id_no]			,			" ).append("\n"); 
		query.append("            ''," ).append("\n"); 
		query.append("			@[cnmv_sts_cd]			," ).append("\n"); 
		query.append("			@[rcv_term_cd]		," ).append("\n"); 
		query.append("			@[de_term_cd]		,			" ).append("\n"); 
		query.append("			@[cntr_vol_qty]		," ).append("\n"); 
		query.append("			@[dcgo_flg]				," ).append("\n"); 
		query.append("			@[rc_flg]				," ).append("\n"); 
		query.append("			@[bb_cgo_flg]			," ).append("\n"); 
		query.append("			@[awk_cgo_flg]			," ).append("\n"); 
		query.append("			@[rd_cgo_flg]			," ).append("\n"); 
		query.append("			@[hngr_flg]				," ).append("\n"); 
		query.append("			@[soc_flg]			," ).append("\n"); 
		query.append("			@[cnmv_evnt_dt]		," ).append("\n"); 
		query.append("			@[cntr_cfm_flg]		," ).append("\n"); 
		query.append("			@[cre_usr_id]		," ).append("\n"); 
		query.append("			sysdate				," ).append("\n"); 
		query.append("			@[upd_usr_id]		," ).append("\n"); 
		query.append("			sysdate				," ).append("\n"); 
		query.append("			TO_DATE(SUBSTR(@[cre_dt],0,19),'YYYY-MM-DD HH24:MI:SS')				, " ).append("\n"); 
		query.append("			TO_DATE(SUBSTR(@[upd_dt],0,19),'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}