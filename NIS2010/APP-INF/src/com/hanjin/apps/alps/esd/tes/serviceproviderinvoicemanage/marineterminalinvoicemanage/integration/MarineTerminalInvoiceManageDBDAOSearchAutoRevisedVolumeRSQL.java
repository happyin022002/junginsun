/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchAutoRevisedVolumeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.30 
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

public class MarineTerminalInvoiceManageDBDAOSearchAutoRevisedVolumeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAutoRevisedVolume
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchAutoRevisedVolumeRSQL(){
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
		params.put("tml_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_wrk_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchAutoRevisedVolumeRSQL").append("\n"); 
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
		query.append("SELECT @[lgs_cost_cd]				RVIS_LGS_COST_CD," ).append("\n"); 
		query.append("        CNTR_NO 					RVIS_CNTR_NO," ).append("\n"); 
		query.append("        CNTR_TPSZ_CD 				RVIS_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        TML_SO_CNTR_LIST_SEQ 		RVIS_TML_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("        CNTR_STY_CD 				RVIS_CNTR_STY_CD," ).append("\n"); 
		query.append("        'TM' 						RVIS_TML_INV_TP_CD," ).append("\n"); 
		query.append("        'TM' 						RVIS_CALC_COST_GRP_CD," ).append("\n"); 
		query.append("		 'V'						RVIS_TML_RVIS_TP_CD," ).append("\n"); 
		query.append("        BKG_NO 						RVIS_BKG_NO," ).append("\n"); 
		query.append("        --BKG_NO_SPLIT 				RVIS_BKG_NO_SPLIT," ).append("\n"); 
		query.append("        VSL_CD 						RVIS_VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO 					RVIS_SKD_VOY_NO," ).append("\n"); 
		query.append("        DECODE(SUBSTR(@[lgs_cost_cd],1,2)," ).append("\n"); 
		query.append("        		'TP', DECODE(NVL(RVIS_IND_FLG,'N'),'Y','1','0')," ).append("\n"); 
		query.append("        		'TM', DECODE(NVL(TML_RVIS_IND_FLG,'N'),'Y','1','0')," ).append("\n"); 
		query.append("        		'SR', DECODE(NVL(STO_RVIS_IND_FLG,'N'),'Y','1','0')," ).append("\n"); 
		query.append("        		'SV', DECODE(NVL(STV_RVIS_IND_FLG,'N'),'Y','1','0')," ).append("\n"); 
		query.append("        		'CG', DECODE(NVL(CGO_RVIS_IND_FLG,'N'),'Y','1','0')) RVIS_IND_FLG" ).append("\n"); 
		query.append(" FROM   TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append(" WHERE  VRFY_RSLT_IND_CD  	= 'CO'" ).append("\n"); 
		query.append(" AND    TML_SO_OFC_CTY_CD 	= @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append(" AND    TML_SO_SEQ   		= @[tml_so_seq]" ).append("\n"); 
		query.append(" AND    DECODE(BB_CGO_FLG,'Y','BB',DECODE(LOCL_TS_IND_CD,'T',DECODE(CNTR_STY_CD,'F','TS','TM'),DECODE(CNTR_STY_CD,'F','FL','MT'))) = SUBSTR(@[lgs_cost_cd],5,2)" ).append("\n"); 
		query.append(" AND    VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append(" AND    SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append(" AND    SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append(" AND    NVL(CNTR_TPSZ_CD,'X') 	= NVL(@[cntr_tpsz_cd],'X')" ).append("\n"); 
		query.append(" AND    NVL(IO_BND_CD,'X') 	= NVL(@[io_bnd_cd],'X')" ).append("\n"); 
		query.append(" AND    NVL(DCGO_CLSS_CD,'X') 	= NVL(@[dcgo_ind_cd],'X')" ).append("\n"); 
		query.append(" AND    NVL(IOC_CD,'X') 		= NVL(@[ioc_cd],'X')" ).append("\n"); 
		query.append(" AND    NVL(LANE_CD,'X') 		= NVL(@[lane_cd],'X')" ).append("\n"); 
		query.append(" AND    DECODE(@[tml_trns_mod_cd],'','S','S','S',NVL(TML_TRNS_MOD_CD,'S')) = NVL(@[tml_trns_mod_cd],'S')" ).append("\n"); 
		query.append(" AND    DECODE((SELECT COUNT(*)" ).append("\n"); 
		query.append("        		 FROM   DMT_HOLIDAY" ).append("\n"); 
		query.append("        		 WHERE  TO_CHAR(HOL_DT,'YYYYMMDD')    = TO_CHAR(WRK_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("        		 AND    CNT_CD    = SUBSTR(@[yd_cd],1,2)" ).append("\n"); 
		query.append("        		  ), 0, DECODE(TO_CHAR(WRK_DT,'D'),7,'SA',1,'SU','WD'),'HO') = NVL(@[tml_wrk_dy_cd],'WD')" ).append("\n"); 
		query.append(" AND    NVL(RC_FLG,'X') = NVL(@[rc_flg],'X')" ).append("\n"); 
		query.append(" ORDER BY CNTR_NO" ).append("\n"); 

	}
}