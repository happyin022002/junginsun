/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeManageDBDAOModifyUSGuaranteeCntrListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.12.07 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeManageDBDAOModifyUSGuaranteeCntrListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee CNTR 목록 수정
	  * </pre>
	  */
	public GuaranteeManageDBDAOModifyUSGuaranteeCntrListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("irr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no_list_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_proc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_gnte_cntr_list_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration").append("\n"); 
		query.append("FileName : GuaranteeManageDBDAOModifyUSGuaranteeCntrListUSQL").append("\n"); 
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
		query.append("UPDATE	TES_GNTE_CNTR_LIST SET" ).append("\n"); 
		query.append("CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD		= @[cntr_tpsz_cd]" ).append("\n"); 
		query.append(", BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append(", BL_NO             = @[bl_no]" ).append("\n"); 
		query.append(", VVD_CD            = @[vvd_cd]" ).append("\n"); 
		query.append(", SC_NO             = @[sc_no]" ).append("\n"); 
		query.append(", FM_DT             = TO_DATE(@[fm_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(", TO_DT             = TO_DATE(@[to_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(", GNTE_AMT          = @[gnte_amt]" ).append("\n"); 
		query.append(", BKG_NO_LIST_CTNT	= SUBSTRB(@[bkg_no_list_ctnt], 0, 1000 )" ).append("\n"); 
		query.append(", GNTE_PROC_TP_CD   = @[gnte_proc_tp_cd]" ).append("\n"); 
		query.append(", IRR_NO            = @[irr_no]" ).append("\n"); 
		query.append(", TML_IF_SEQ        = @[tml_if_seq]" ).append("\n"); 
		query.append(", TML_IF_OFC_CD     = @[tml_if_ofc_cd]" ).append("\n"); 
		query.append(", UPD_USR_ID        = @[upd_usr_id]" ).append("\n"); 
		query.append(", UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("#if (${gnte_no} != '')" ).append("\n"); 
		query.append("AND		GNTE_NO		= @[gnte_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${irr_no} != '')" ).append("\n"); 
		query.append("AND		IRR_NO		= @[irr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND		TML_GNTE_CNTR_LIST_SEQ = @[tml_gnte_cntr_list_seq]" ).append("\n"); 

	}
}