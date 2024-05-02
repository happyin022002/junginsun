/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOModifyCntrMasterByMvmtDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * 2010.12.02 남궁진호[CHM-201007506-01] velParam  변수의 null값 인식오류에 의한 수정
	  * 2011.05.02 남궁진호[CHM-201110515-01] U/C으로 Flagging되어있는 CNTR가 ID 상태에서 MT 상태로 변경될대 U/C Flagging 자동해제
	  * 2013.04.05 채창호[CHM-201323894]  ALPS Master에서L/S & U/C Creation 자동 Unflagging 요청         
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
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_sts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aciac_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.integration").append("\n"); 
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
		query.append("         ONH_YD_CD       = 'KRSEL1H'," ).append("\n"); 
		query.append("         CRNT_YD_CD      = 'KRSEL1H', " ).append("\n"); 
		query.append("         LOC_CD          = 'KRSEL'," ).append("\n"); 
		query.append("         SCC_CD          = 'KRSEL'," ).append("\n"); 
		query.append("         ECC_CD          = 'KREIW'," ).append("\n"); 
		query.append("         LCC_CD          = 'KRINC'," ).append("\n"); 
		query.append("         RCC_CD          = 'KRSEL'," ).append("\n"); 
		query.append("         CNMV_DT         = MST.MFT_DT," ).append("\n"); 
		query.append("         CNMV_GDT	     = GLOBALDATE_PKG.TIME_CONV_FNC ( 'KRSEL', MST.MFT_DT, 'GMT' )," ).append("\n"); 
		query.append("         ACIAC_DIV_CD    = 'I'," ).append("\n"); 
		query.append("         HJS_CRE_FLG     = 'Y'," ).append("\n"); 
		query.append("         SYS_AREA_GRP_ID = 'KOR'," ).append("\n"); 
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
		query.append("         --  (U) Uncliamed Container 이면서 ID상태에서 MT 이 입력되면 Uncliamed Status를 해제한다." ).append("\n"); 
		query.append("         --현재 LS & UC Creation 자동 Unflagging 요청" ).append("\n"); 
		query.append("              -- L  - LS_FLG 일때 조건  MVMT 가 ID-> MT or OC->VL or MT-> VL or MT->OC 변동 시, L- LS-FLG 제거" ).append("\n"); 
		query.append("              -- U -  UC_FLG 일때 조건  MVMT 가 ID-> MT or OC->VL 변동 시,  UC_FLG 제거" ).append("\n"); 
		query.append("              -- MVMT CD 가 MT 에서 VL로 변동 하거나 MT가 OC로 변동 하게 되면  L/S Flag 를 제거 한다 " ).append("\n"); 
		query.append("          UCLM_LS_DIV_CD 	    =  CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] = ('OCVL') THEN" ).append("\n"); 
		query.append("                                            UCLM_LS_DIV_CD" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_LS_DIV_CD" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                        CASE WHEN UCLM_LS_DIV_CD ='L' THEN" ).append("\n"); 
		query.append("                                             CASE WHEN CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('OCVL') OR" ).append("\n"); 
		query.append("                                                       CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTVL') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTOP') THEN" ).append("\n"); 
		query.append("                                                  NULL" ).append("\n"); 
		query.append("                                             ELSE" ).append("\n"); 
		query.append("                                                  UCLM_LS_DIV_CD" ).append("\n"); 
		query.append("                                             END" ).append("\n"); 
		query.append("                               " ).append("\n"); 
		query.append("                                        END " ).append("\n"); 
		query.append("                                   END,            " ).append("\n"); 
		query.append("	        UCLM_DT 		    =  CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] = ('OCVL') THEN" ).append("\n"); 
		query.append("                                            UCLM_DT" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_DT" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                        CASE WHEN UCLM_LS_DIV_CD ='L' THEN" ).append("\n"); 
		query.append("                                             CASE WHEN CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('OCVL') OR" ).append("\n"); 
		query.append("                                                       CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTVL') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTOP') THEN" ).append("\n"); 
		query.append("                                                  NULL" ).append("\n"); 
		query.append("                                             ELSE" ).append("\n"); 
		query.append("                                                  UCLM_DT" ).append("\n"); 
		query.append("                                             END" ).append("\n"); 
		query.append("                                        END  " ).append("\n"); 
		query.append("                                   END," ).append("\n"); 
		query.append("	        UCLM_FREE_DYS		= CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] = ('OCVL') THEN" ).append("\n"); 
		query.append("                                            UCLM_FREE_DYS" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_FREE_DYS" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                        CASE WHEN UCLM_LS_DIV_CD ='L' THEN" ).append("\n"); 
		query.append("                                             CASE WHEN CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('OCVL') OR" ).append("\n"); 
		query.append("                                                       CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTVL') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTOP') THEN" ).append("\n"); 
		query.append("                                                  NULL" ).append("\n"); 
		query.append("                                             ELSE" ).append("\n"); 
		query.append("                                                  UCLM_FREE_DYS" ).append("\n"); 
		query.append("                                             END" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                   END," ).append("\n"); 
		query.append("	        UCLM_END_DT		    = CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] = ('OCVL') THEN" ).append("\n"); 
		query.append("                                            UCLM_END_DT" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_END_DT" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                        CASE WHEN UCLM_LS_DIV_CD ='L' THEN" ).append("\n"); 
		query.append("                                             CASE WHEN CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('OCVL') OR" ).append("\n"); 
		query.append("                                                       CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTVL') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTOP') THEN" ).append("\n"); 
		query.append("                                                  NULL" ).append("\n"); 
		query.append("                                             ELSE" ).append("\n"); 
		query.append("                                                  UCLM_END_DT" ).append("\n"); 
		query.append("                                             END" ).append("\n"); 
		query.append("                                         END " ).append("\n"); 
		query.append("                                   END," ).append("\n"); 
		query.append("	        UCLM_RSN		    = CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] = ('OCVL') THEN" ).append("\n"); 
		query.append("                                            UCLM_RSN" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_RSN" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                        CASE WHEN UCLM_LS_DIV_CD ='L' THEN" ).append("\n"); 
		query.append("                                             CASE WHEN CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('OCVL') OR" ).append("\n"); 
		query.append("                                                       CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTVL') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTOP') THEN" ).append("\n"); 
		query.append("                                                  NULL" ).append("\n"); 
		query.append("                                             ELSE" ).append("\n"); 
		query.append("                                                  UCLM_RSN" ).append("\n"); 
		query.append("                                             END" ).append("\n"); 
		query.append("                                        END " ).append("\n"); 
		query.append("                                   END," ).append("\n"); 
		query.append("	        UCLM_PLN_RMK		= CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] = ('OCVL') THEN" ).append("\n"); 
		query.append("                                             UCLM_PLN_RMK" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_PLN_RMK" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                        CASE WHEN UCLM_LS_DIV_CD ='L' THEN" ).append("\n"); 
		query.append("                                             CASE WHEN CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('OCVL') OR" ).append("\n"); 
		query.append("                                                       CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTVL') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTOP') THEN" ).append("\n"); 
		query.append("                                                  NULL" ).append("\n"); 
		query.append("                                             ELSE" ).append("\n"); 
		query.append("                                                  UCLM_PLN_RMK" ).append("\n"); 
		query.append("                                             END" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                                        END " ).append("\n"); 
		query.append("                                   END," ).append("\n"); 
		query.append("	        UCLM_CNTC_PNT_NM	= CASE WHEN UCLM_LS_DIV_CD ='U' THEN" ).append("\n"); 
		query.append("                                        CASE WHEN  CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] = ('OCVL') THEN" ).append("\n"); 
		query.append("                                             UCLM_CNTC_PNT_NM" ).append("\n"); 
		query.append("                                        ELSE" ).append("\n"); 
		query.append("                                            UCLM_CNTC_PNT_NM" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("                                   ELSE" ).append("\n"); 
		query.append("                                        CASE WHEN UCLM_LS_DIV_CD ='L' THEN" ).append("\n"); 
		query.append("                                             CASE WHEN CNMV_STS_CD || @[mvmt_sts_cd] IN ('IDMT') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('OCVL') OR" ).append("\n"); 
		query.append("                                                       CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTVL') OR  CNMV_STS_CD || @[mvmt_sts_cd] IN ('MTOP') THEN" ).append("\n"); 
		query.append("                                                  NULL" ).append("\n"); 
		query.append("                                             ELSE" ).append("\n"); 
		query.append("                                                  UCLM_CNTC_PNT_NM" ).append("\n"); 
		query.append("                                             END" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                        END " ).append("\n"); 
		query.append("                                   END," ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         HJS_CRE_FLG        = 'N' ," ).append("\n"); 
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