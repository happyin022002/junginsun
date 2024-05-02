/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMasterByMvmtDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOModifyCntrMasterByMvmtDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrMasterByMvmtData
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOModifyCntrMasterByMvmtDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("std_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("std_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aciac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("std_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("std_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("std_rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("std_area_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("std_lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOModifyCntrMasterByMvmtDataUSQL").append("\n"); 
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
		query.append("UPDATE MST_CONTAINER MST" ).append("\n"); 
		query.append("      SET  " ).append("\n"); 
		query.append("#if (${new_flg} == 'C' ) -- 'C' : 신조 MOVEMENT 취소,'X' : 'SH' 장비 XX 처리" ).append("\n"); 
		query.append("         ONH_YD_CD       = @[std_yd_cd]," ).append("\n"); 
		query.append("         CRNT_YD_CD      = @[std_yd_cd], " ).append("\n"); 
		query.append("         LOC_CD          = @[std_loc_cd]," ).append("\n"); 
		query.append("         SCC_CD          = @[std_scc_cd]," ).append("\n"); 
		query.append("         ECC_CD          = @[std_ecc_cd]," ).append("\n"); 
		query.append("         LCC_CD          = @[std_lcc_cd]," ).append("\n"); 
		query.append("         RCC_CD          = @[std_rcc_cd]," ).append("\n"); 
		query.append("         CNMV_DT         = MST.MFT_DT," ).append("\n"); 
		query.append("         CNMV_GDT	     = GLOBALDATE_PKG.TIME_CONV_FNC ( COM_CONSTANTMGR_PKG.COM_getBaseLocationCode_FNC(), MST.MFT_DT, 'GMT' )," ).append("\n"); 
		query.append("         ACIAC_DIV_CD    = 'I'," ).append("\n"); 
		query.append("         CO_CRE_FLG     = 'Y'," ).append("\n"); 
		query.append("         SYS_AREA_GRP_ID = @[std_area_cd]," ).append("\n"); 
		query.append("         CNTR_AUTH_NO    = null," ).append("\n"); 
		query.append("         CNMV_STS_CD     = 'MT'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         SYS_AREA_GRP_ID = @[cntr_svr_id]   ," ).append("\n"); 
		query.append("         #if (${new_flg} == 'B' )" ).append("\n"); 
		query.append("	     ONH_DT		    = TRUNC(TO_DATE(@[cnmv_evnt_dt], 'YYYYMMDD HH24:MI')),	" ).append("\n"); 
		query.append("	     ONH_YD_CD  	= @[org_yd_cd],	" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("	     CNMV_YR        = @[cnmv_yr]        ," ).append("\n"); 
		query.append("         CNMV_ID_NO     = @[cnmv_id_no]     ," ).append("\n"); 
		query.append("         CNMV_SEQ       = @[cnmv_seq]       ," ).append("\n"); 
		query.append("         CNMV_SPLIT_NO  = @[cnmv_split_no]  ," ).append("\n"); 
		query.append("         CNMV_CYC_NO    = @[cnmv_cyc_no]    ," ).append("\n"); 
		query.append("         CNMV_DT        = TO_DATE(@[cnmv_evnt_dt], 'YYYYMMDD HH24:MI')," ).append("\n"); 
		query.append("         CNMV_GDT	    = GLOBALDATE_PKG.TIME_CONV_FNC ( SUBSTR(@[org_yd_cd], 1, 5), TO_DATE(@[cnmv_evnt_dt], 'YYYYMMDD HH24:MI'), 'GMT' )," ).append("\n"); 
		query.append("	     PRE_STS_FLG    = @[pre_sts_flg]    ," ).append("\n"); 
		query.append("	     BKG_NO         = @[bkg_no] 	    ," ).append("\n"); 
		query.append("	     BKG_KNT        = @[bkg_knt]	    ," ).append("\n"); 
		query.append("         FULL_FLG       = DECODE(@[fcntr_flg], NULL, 'N' ,'F', 'Y', 'M', 'N', 'Y','Y', 'E', 'N', @[fcntr_flg] )," ).append("\n"); 
		query.append("         CRNT_YD_CD     = @[org_yd_cd]      ," ).append("\n"); 
		query.append("         DEST_YD_CD     = @[dest_yd_cd]     ," ).append("\n"); 
		query.append("         VSL_CD         = SUBSTR(@[cntr_id], 0,4)        ," ).append("\n"); 
		query.append("         SKD_VOY_NO     = SUBSTR(@[cntr_id], 5,4)        ," ).append("\n"); 
		query.append("         SKD_DIR_CD     = SUBSTR(@[cntr_id], 9,1)        ," ).append("\n"); 
		query.append("         CNMV_STS_CD    = @[mvmt_sts_cd]    ," ).append("\n"); 
		query.append("		 IMDT_EXT_FLG   = DECODE(@[mvmt_sts_cd]||MST.LSTM_CD,'VLOF','Y','VLMI','Y',MST.IMDT_EXT_FLG)," ).append("\n"); 
		query.append("	     (LOC_CD, SCC_CD, LCC_CD, ECC_CD, RCC_CD) = " ).append("\n"); 
		query.append("	     (" ).append("\n"); 
		query.append("	       SELECT" ).append("\n"); 
		query.append("                   B.LOC_CD, " ).append("\n"); 
		query.append("                   A.SCC_CD," ).append("\n"); 
		query.append("                   A.LCC_CD, " ).append("\n"); 
		query.append("                   A.ECC_CD," ).append("\n"); 
		query.append("                   A.RCC_CD " ).append("\n"); 
		query.append("            FROM   MDM_EQ_ORZ_CHT A, MDM_LOCATION B" ).append("\n"); 
		query.append("            WHERE  A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("            AND    B.LOC_CD = SUBSTR(@[org_yd_cd],0,5) 		" ).append("\n"); 
		query.append("	     )," ).append("\n"); 
		query.append("         #if (${ctm_ui_yn} == 'Y' )" ).append("\n"); 
		query.append("         -- CTM/Movement History Update UI에서 호출시 (제외)" ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("         -- 다른 UI and EDI에서 호출시." ).append("\n"); 
		query.append("         -- As-Is : UI을 통해서 MT 일 경우에 Manual 작업으로 Uncliamed Status를 해제 했다." ).append("\n"); 
		query.append("         -- To-Be : Manual 작업 뿐만 아니라, Auto로 Uncliamed Status를 해제할 수 있도록 한다." ).append("\n"); 
		query.append("         -- [변경 내용]" ).append("\n"); 
		query.append("         -- 현재 (U) Uncliamed Container 이면서 ID상태에서 MT 이 입력되면 Uncliamed Status를 해제한다." ).append("\n"); 
		query.append("          UCLM_LS_DIV_CD 	    =  CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') THEN" ).append("\n"); 
		query.append("                                             NULL" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_LS_DIV_CD" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        NULL" ).append("\n"); 
		query.append("                                    END,            " ).append("\n"); 
		query.append("	        UCLM_DT 		    =  CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') THEN" ).append("\n"); 
		query.append("                                             NULL" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_DT" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        NULL" ).append("\n"); 
		query.append("                                    END," ).append("\n"); 
		query.append("	        UCLM_FREE_DYS		= CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') THEN" ).append("\n"); 
		query.append("                                             NULL" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_FREE_DYS" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        NULL" ).append("\n"); 
		query.append("                                    END," ).append("\n"); 
		query.append("	        UCLM_END_DT		    = CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') THEN" ).append("\n"); 
		query.append("                                             NULL" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_END_DT" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        NULL" ).append("\n"); 
		query.append("                                    END," ).append("\n"); 
		query.append("	        UCLM_RSN		    = CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') THEN" ).append("\n"); 
		query.append("                                             NULL" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_RSN" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        NULL" ).append("\n"); 
		query.append("                                    END," ).append("\n"); 
		query.append("	        UCLM_PLN_RMK		= CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') THEN" ).append("\n"); 
		query.append("                                             NULL" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_PLN_RMK" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        NULL" ).append("\n"); 
		query.append("                                    END," ).append("\n"); 
		query.append("	        UCLM_CNTC_PNT_NM	= CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') THEN" ).append("\n"); 
		query.append("                                             NULL" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_CNTC_PNT_NM" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        NULL" ).append("\n"); 
		query.append("                                    END," ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         CO_CRE_FLG         = 'N' ," ).append("\n"); 
		query.append("         ACIAC_DIV_CD       = NVL(@[aciac_div_cd],'A')," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${new_flg} == 'X')" ).append("\n"); 
		query.append("	 CNTR_STS_CD	= 'LSO'," ).append("\n"); 
		query.append("	 LST_STS_YD_CD  = @[org_yd_cd]," ).append("\n"); 
		query.append("	 LST_STS_SEQ    = MST_CNTR_STS_HIS_SEQ.NEXTVAL," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 UPD_USR_ID     = @[upd_usr_id]," ).append("\n"); 
		query.append("	 UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	 MST.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}