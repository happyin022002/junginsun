/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchManualRevisedVolumeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchManualRevisedVolumeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchManualRevisedVolume
	  * 
	  * * 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchManualRevisedVolumeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_rvis_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_rvis_cntr_sty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_rvis_locl_ts_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchManualRevisedVolumeRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.TML_SO_RVIS_LIST_SEQ,NULL,DECODE(A.RVIS_IND_FLG,0,'I','R'),'R') IBFLAG, -- IBFLAG값만 일단 변경함  RVIS_IBFLAG," ).append("\n"); 
		query.append("				A.CNTR_NO			RVIS_CNTR_NO," ).append("\n"); 
		query.append("				A.LGS_COST_CD		RVIS_LGS_COST_CD," ).append("\n"); 
		query.append("				A.TML_INV_TP_CD		RVIS_TML_INV_TP_CD," ).append("\n"); 
		query.append("				A.CALC_COST_GRP_CD	RVIS_CALC_COST_GRP_CD," ).append("\n"); 
		query.append("				A.TML_RVIS_TP_CD	RVIS_TML_RVIS_TP_CD," ).append("\n"); 
		query.append("				A.RVIS_CALC_TP_CD	RVIS_CALC_TP_CD," ).append("\n"); 
		query.append("				A.RVIS_IND_FLG		RVIS_IND_FLG," ).append("\n"); 
		query.append("				A.TML_SO_DTL_SEQ	RVIS_TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("				A.TML_SO_RVIS_LIST_SEQ		RVIS_TML_SO_RVIS_LIST_SEQ," ).append("\n"); 
		query.append("				A.CNTR_TPSZ_CD		RVIS_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("				A.CNTR_STY_CD		RVIS_CNTR_STY_CD," ).append("\n"); 
		query.append("				A.BKG_NO			RVIS_BKG_NO," ).append("\n"); 
		query.append("				--A.BKG_NO_SPLIT		RVIS_BKG_NO_SPLIT," ).append("\n"); 
		query.append("				A.VSL_CD			RVIS_VSL_CD," ).append("\n"); 
		query.append("				A.SKD_VOY_NO		RVIS_SKD_VOY_NO,  " ).append("\n"); 
		query.append("				A.SKD_DIR_CD		RVIS_SKD_DIR_CD," ).append("\n"); 
		query.append("                CASE WHEN M.CNTR_TPSZ_CD IS NOT NULL THEN 'Y' ELSE 'N' END EFF_CNTR_YN," ).append("\n"); 
		query.append("				CASE WHEN A.TML_SO_CNTR_LIST_SEQ IS NOT NULL THEN A.TML_SO_CNTR_LIST_SEQ ELSE '' END RVIS_TML_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("				TO_CHAR(A.PLG_IN_DT,'YYYYMMDD HH24MI')		AS RVIS_PLUG_IN," ).append("\n"); 
		query.append("				TO_CHAR(A.PLG_OUT_DT,'YYYYMMDD HH24MI')		AS RVIS_PLUG_OUT," ).append("\n"); 
		query.append("				A.PLG_TERM_DYS		RVIS_PLUG_TERM" ).append("\n"); 
		query.append("		FROM(" ).append("\n"); 
		query.append("				SELECT  DECODE(C.CNTR_NO,'',R.CNTR_NO,C.CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append("				        ,@[lgs_cost_cd] LGS_COST_CD" ).append("\n"); 
		query.append("				        ,'TM' TML_INV_TP_CD" ).append("\n"); 
		query.append("				        ,'TM' CALC_COST_GRP_CD" ).append("\n"); 
		query.append("				        ,'V' TML_RVIS_TP_CD" ).append("\n"); 
		query.append("				        ,'M' RVIS_CALC_TP_CD" ).append("\n"); 
		query.append("					#if (${rvis_div} == 'DG')" ).append("\n"); 
		query.append("						,DECODE(R.RVIS_IND_FLG,'',DECODE(C.DCGO_CLSS_CD,'N','0','1'),DECODE(R.RVIS_IND_FLG,'Y','1','0')) RVIS_IND_FLG" ).append("\n"); 
		query.append("					#elseif (${rvis_div} == 'AK')" ).append("\n"); 
		query.append("						,DECODE(R.RVIS_IND_FLG,'',DECODE(NVL(C.AWK_CGO_FLG,'N'),'N','0','1'),DECODE(R.RVIS_IND_FLG,'Y','1','0')) RVIS_IND_FLG" ).append("\n"); 
		query.append("					#elseif (${rvis_div} == 'RF')" ).append("\n"); 
		query.append("						,DECODE(R.RVIS_IND_FLG,'',DECODE(NVL(C.RC_FLG,'N'),'N','0','1'),DECODE(R.RVIS_IND_FLG,'Y','1','0'))RVIS_IND_FLG" ).append("\n"); 
		query.append("					#elseif (${rvis_div} == 'MT')" ).append("\n"); 
		query.append("						,DECODE(R.RVIS_IND_FLG,'',DECODE(C.CNTR_STY_CD,'M','1','0'),DECODE(R.RVIS_IND_FLG,'Y','1','0')) RVIS_IND_FLG" ).append("\n"); 
		query.append("					#elseif (${rvis_div} == 'N')" ).append("\n"); 
		query.append("						,DECODE(R.RVIS_IND_FLG,'Y','1','0') RVIS_IND_FLG" ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("						,'' RVIS_IND_FLG" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				        ,R.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("				        ,R.TML_SO_RVIS_LIST_SEQ" ).append("\n"); 
		query.append("				        ,C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				        ,C.CNTR_STY_CD" ).append("\n"); 
		query.append("				        ,C.BKG_NO" ).append("\n"); 
		query.append("				        --,C.BKG_NO_SPLIT" ).append("\n"); 
		query.append("				        ,C.VSL_CD" ).append("\n"); 
		query.append("				        ,C.SKD_VOY_NO" ).append("\n"); 
		query.append("				        ,C.SKD_DIR_CD" ).append("\n"); 
		query.append("						,C.TML_SO_CNTR_LIST_SEQ||'' TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("						,R.PLG_IN_DT" ).append("\n"); 
		query.append("						,R.PLG_OUT_DT" ).append("\n"); 
		query.append("						,R.PLG_TERM_DYS" ).append("\n"); 
		query.append("				FROM   TES_TML_SO_CNTR_LIST C, TES_TML_SO_RVIS_LIST R" ).append("\n"); 
		query.append("				WHERE  C.VRFY_RSLT_IND_CD  	= 'CO'" ).append("\n"); 
		query.append("				AND    C.TML_SO_OFC_CTY_CD 	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("				AND    C.TML_SO_SEQ   		= @[tml_so_seq]" ).append("\n"); 
		query.append("				AND    C.VSL_CD			= SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("				AND    C.SKD_VOY_NO		= SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("				AND    C.SKD_DIR_CD		= SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("				AND    C.TML_SO_OFC_CTY_CD	= R.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("				AND    C.TML_SO_SEQ		= R.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("				AND    NVL(@[tml_so_dtl_seq],0)	= R.TML_SO_DTL_SEQ(+)" ).append("\n"); 
		query.append("				-- // CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-04-03 양양선B 요청)" ).append("\n"); 
		query.append("				#if ($param_rvis_cntr_tpsz_cd.size() > 0) " ).append("\n"); 
		query.append("				AND		C.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("				#foreach($rvis_cntr_tpsz_cd_num IN ${param_rvis_cntr_tpsz_cd})" ).append("\n"); 
		query.append("					#if($velocityCount < $param_rvis_cntr_tpsz_cd.size()) " ).append("\n"); 
		query.append("						'$rvis_cntr_tpsz_cd_num', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$rvis_cntr_tpsz_cd_num' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("				AND		DECODE(@[cntr_tpsz_cd], '', 'X', @[cntr_tpsz_cd]) = DECODE(@[cntr_tpsz_cd], '', 'X', C.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${param_rvis_io_bnd_cd} != '')" ).append("\n"); 
		query.append("				AND    C.IO_BND_CD			= @[param_rvis_io_bnd_cd]" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				AND    C.IO_BND_CD			= @[io_bnd_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${param_rvis_cntr_sty_cd} != '')" ).append("\n"); 
		query.append("				AND    C.CNTR_STY_CD		= @[param_rvis_cntr_sty_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${param_rvis_locl_ts_ind_cd} != '')" ).append("\n"); 
		query.append("				AND    C.LOCL_TS_IND_CD		= @[param_rvis_locl_ts_ind_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				AND    C.CNTR_NO 			= R.CNTR_NO(+)" ).append("\n"); 
		query.append("				AND    C.CNTR_TPSZ_CD		= R.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("				AND    R.LGS_COST_CD(+) 	= @[lgs_cost_cd]" ).append("\n"); 
		query.append("				AND    NVL(C.RC_FLG,'X')    = NVL(@[rc_flg],'X')" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("				SELECT DISTINCT R.CNTR_NO" ).append("\n"); 
		query.append("				        ,@[lgs_cost_cd] LGS_COST_CD" ).append("\n"); 
		query.append("				        ,'TM' TML_INV_TP_CD" ).append("\n"); 
		query.append("				        ,'TM' CALC_COST_GRP_CD" ).append("\n"); 
		query.append("				        ,'V' TML_RVIS_TP_CD" ).append("\n"); 
		query.append("				        ,'M' RVIS_CALC_TP_CD" ).append("\n"); 
		query.append("				        ,DECODE(R.RVIS_IND_FLG,'Y','1','0') RVIS_IND_FLG" ).append("\n"); 
		query.append("				        ,R.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("				        ,R.TML_SO_RVIS_LIST_SEQ" ).append("\n"); 
		query.append("				        ,R.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				        ,R.CNTR_STY_CD" ).append("\n"); 
		query.append("				        ,R.BKG_NO" ).append("\n"); 
		query.append("				        --,R.BKG_NO_SPLIT" ).append("\n"); 
		query.append("				        ,R.VSL_CD" ).append("\n"); 
		query.append("				        ,R.SKD_VOY_NO" ).append("\n"); 
		query.append("				        ,R.SKD_DIR_CD" ).append("\n"); 
		query.append("						, '' TML_SO_CNTR_LIST_SEQ" ).append("\n"); 
		query.append("						,R.PLG_IN_DT" ).append("\n"); 
		query.append("						,R.PLG_OUT_DT" ).append("\n"); 
		query.append("						,R.PLG_TERM_DYS" ).append("\n"); 
		query.append("				FROM TES_TML_SO_RVIS_LIST R, TES_TML_SO_CNTR_LIST C" ).append("\n"); 
		query.append("				WHERE R.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("				AND    R.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("				AND    R.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("				AND    R.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("				AND    R.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("				AND    R.VSL_CD     = C.VSL_CD(+)" ).append("\n"); 
		query.append("				AND    R.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("				AND    R.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("				AND    R.TML_SO_OFC_CTY_CD = C.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("				AND    R.TML_SO_SEQ = C.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("				AND    R.TML_SO_DTL_SEQ = @[tml_so_dtl_seq]" ).append("\n"); 
		query.append("				AND    R.CNTR_NO NOT IN (SELECT CNTR_NO FROM TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("				                         WHERE     VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("				                            AND    SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("				                            AND    SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("				                            AND    IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("				                            AND    VRFY_RSLT_IND_CD = 'CO'" ).append("\n"); 
		query.append("				                            AND    TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("				                            AND    TML_SO_SEQ = @[tml_so_seq])--C.CNTR_NO" ).append("\n"); 
		query.append("				AND    R.LGS_COST_CD = @[lgs_cost_cd] ) A, MST_CONTAINER M" ).append("\n"); 
		query.append("        WHERE A.CNTR_NO = M.CNTR_NO(+)" ).append("\n"); 
		query.append("		ORDER BY A.CNTR_NO, A.BKG_NO" ).append("\n"); 

	}
}