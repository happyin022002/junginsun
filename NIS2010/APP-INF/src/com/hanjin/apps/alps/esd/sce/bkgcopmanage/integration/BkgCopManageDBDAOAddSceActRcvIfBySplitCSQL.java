/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOAddSceActRcvIfBySplitCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.24
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.05.24 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOAddSceActRcvIfBySplitCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * split 시 기존 actual 정보 (split 원부킹 으로 넘어온 actual 정보) 를 가져와 booking No 만 split 이후의 booking no 로 치환하여
	  * sce_act_rcv_if 에 '00' 으로 insert (actual mapping 과 EDI 315 전송을 유도)
	  * </pre>
	  */
	public BkgCopManageDBDAOAddSceActRcvIfBySplitCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("new_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOAddSceActRcvIfBySplitCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO SCE_ACT_RCV_IF (" ).append("\n"); 
		query.append("ACT_RCV_DT," ).append("\n"); 
		query.append("ACT_RCV_NO," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("ACT_DT," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD," ).append("\n"); 
		query.append("NOD_CD," ).append("\n"); 
		query.append("ACT_RCV_TP_CD," ).append("\n"); 
		query.append("COP_RLT_FLG," ).append("\n"); 
		query.append("ACT_UMCH_TP_CD," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("VPS_PORT_CD," ).append("\n"); 
		query.append("CLPT_IND_SEQ," ).append("\n"); 
		query.append("CALL_YD_IND_SEQ," ).append("\n"); 
		query.append("EDI_MSG_TP_CD ," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("ERR_MSG," ).append("\n"); 
		query.append("BND_VSKD_SEQ_CD," ).append("\n"); 
		query.append("COP_EVNT_SEQ," ).append("\n"); 
		query.append("ACT_GDT," ).append("\n"); 
		query.append("ACT_DAT_RCV_DT," ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("FAX_SND_RSLT_FLG," ).append("\n"); 
		query.append("EML_SND_RSLT_FLG," ).append("\n"); 
		query.append("EDI_SND_RSLT_FLG," ).append("\n"); 
		query.append("ACT_CD," ).append("\n"); 
		query.append("RTY_RSLT_FLG," ).append("\n"); 
		query.append("VNDR_NM," ).append("\n"); 
		query.append("CRE_TP_CD," ).append("\n"); 
		query.append("PRE_BKG_NO," ).append("\n"); 
		query.append("RAIL_DEST_N1ST_ETA_DT," ).append("\n"); 
		query.append("VSL_DLAY_RSN_CD," ).append("\n"); 
		query.append("VSL_DLAY_RSN_DESC," ).append("\n"); 
		query.append("VPS_LOC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TO_CHAR(SYSDATE, 'YYYYMMDD') ," ).append("\n"); 
		query.append("sce_act_rcv_if_seq1.NEXTVAL ," ).append("\n"); 
		query.append("@[new_bkg_no] ," ).append("\n"); 
		query.append("@[cntr_no] ," ).append("\n"); 
		query.append("ACT_DT ," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD ," ).append("\n"); 
		query.append("NOD_CD ," ).append("\n"); 
		query.append("ACT_RCV_TP_CD ," ).append("\n"); 
		query.append("COP_RLT_FLG ," ).append("\n"); 
		query.append("'00' , --ACT_UMCH_TP_CD" ).append("\n"); 
		query.append("SYSDATE , --SYSDATE            --COMBINEorSPLIT TIME" ).append("\n"); 
		query.append("VSL_CD ," ).append("\n"); 
		query.append("SKD_VOY_NO ," ).append("\n"); 
		query.append("SKD_DIR_CD ," ).append("\n"); 
		query.append("VPS_PORT_CD ," ).append("\n"); 
		query.append("CLPT_IND_SEQ ," ).append("\n"); 
		query.append("CALL_YD_IND_SEQ," ).append("\n"); 
		query.append("EDI_MSG_TP_CD ," ).append("\n"); 
		query.append("VNDR_SEQ ," ).append("\n"); 
		query.append("'' AS ERR_MSG ," ).append("\n"); 
		query.append("BND_VSKD_SEQ_CD ," ).append("\n"); 
		query.append("1 ," ).append("\n"); 
		query.append("ACT_GDT ," ).append("\n"); 
		query.append("ACT_DAT_RCV_DT ," ).append("\n"); 
		query.append("@[cop_no] ," ).append("\n"); 
		query.append("FAX_SND_RSLT_FLG ," ).append("\n"); 
		query.append("EML_SND_RSLT_FLG ," ).append("\n"); 
		query.append("'N' ," ).append("\n"); 
		query.append("ACT_CD ," ).append("\n"); 
		query.append("RTY_RSLT_FLG ," ).append("\n"); 
		query.append("VNDR_NM ," ).append("\n"); 
		query.append("CRE_TP_CD ," ).append("\n"); 
		query.append("PRE_BKG_NO ," ).append("\n"); 
		query.append("RAIL_DEST_N1ST_ETA_DT ," ).append("\n"); 
		query.append("VSL_DLAY_RSN_CD ," ).append("\n"); 
		query.append("VSL_DLAY_RSN_DESC ," ).append("\n"); 
		query.append("VPS_LOC_CD," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM SCE_ACT_RCV_IF" ).append("\n"); 
		query.append("WHERE (ACT_RCV_DT," ).append("\n"); 
		query.append("ACT_RCV_NO) IN (" ).append("\n"); 
		query.append("SELECT SUBSTR(MAX(ACT_RCV_DT||ACT_RCV_NO), 1, 8) ACT_RCV_DT," ).append("\n"); 
		query.append("SUBSTR(MAX(ACT_RCV_DT||ACT_RCV_NO), 9) ACT_RCV_NO --최근 수신된 Actual" ).append("\n"); 
		query.append("FROM SCE_ACT_RCV_IF" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND BKG_NO IN (" ).append("\n"); 
		query.append("#foreach($ele IN ${bkg_no})" ).append("\n"); 
		query.append("#if($velocityCount == 1 )" ).append("\n"); 
		query.append("'$ele'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$ele'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND ACT_RCV_TP_CD IN ('1'," ).append("\n"); 
		query.append("'3'," ).append("\n"); 
		query.append("'9')" ).append("\n"); 
		query.append("GROUP BY ACT_DT, ACT_RCV_TP_CD, ACT_STS_MAPG_CD, NOD_CD" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT SUBSTR(MAX(ACT_RCV_DT||ACT_RCV_NO), 1, 8) ACT_RCV_DT," ).append("\n"); 
		query.append("SUBSTR(MAX(ACT_RCV_DT||ACT_RCV_NO), 9) ACT_RCV_NO --최근 수신된 VSL Actual" ).append("\n"); 
		query.append("FROM SCE_ACT_RCV_IF A," ).append("\n"); 
		query.append("SCE_COP_DTL D" ).append("\n"); 
		query.append("WHERE D.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND D.COP_DTL_SEQ BETWEEN 4000 AND 6000" ).append("\n"); 
		query.append("AND SUBSTR(D.ACT_CD, 5, 1) IN ('A'," ).append("\n"); 
		query.append("'B'," ).append("\n"); 
		query.append("'D')" ).append("\n"); 
		query.append("AND A.VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.VPS_PORT_CD = D.VPS_PORT_CD" ).append("\n"); 
		query.append("AND A.CLPT_IND_SEQ = D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND A.ACT_RCV_TP_CD = '2'" ).append("\n"); 
		query.append("AND SUBSTR(A.ACT_STS_MAPG_CD, 3, 1) = SUBSTR(D.ACT_CD, 5, 1)" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.VPS_PORT_CD," ).append("\n"); 
		query.append("A.ACT_STS_MAPG_CD, A.CLPT_IND_SEQ )" ).append("\n"); 

	}
}