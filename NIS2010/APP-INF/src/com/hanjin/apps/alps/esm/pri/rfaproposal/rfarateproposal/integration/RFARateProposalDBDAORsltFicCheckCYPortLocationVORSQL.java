/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RFARateProposalDBDAORsltFicCheckCYPortLocationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateProposalDBDAORsltFicCheckCYPortLocationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CY Port인지 확인 하는 화면을 위한 쿼리
	  * 2013.02.21 [CHM-201323199] 전윤주 calling port flag가 'Y' 이더라도 exception table에 flag를 참조하여 including IHC 탭에만 넣어야 하는 location 구분 로직 추가 
	  * </pre>
	  */
	public RFARateProposalDBDAORsltFicCheckCYPortLocationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration").append("\n"); 
		query.append("FileName : RFARateProposalDBDAORsltFicCheckCYPortLocationVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT MDM.LOC_CD, DECODE(PRC_IHC_ONY_FLG, 'Y', 'N', MDM.CALL_PORT_FLG) CALL_PORT_FLG--exception 테이블의 IHC Only flag가 'Y' 이면 call port flag를 N 으로 return" ).append("\n"); 
		query.append("FROM MDM_LOCATION MDM" ).append("\n"); 
		query.append("    ,PRI_TRF_IHC_EXPT_CY_LOC EXPT" ).append("\n"); 
		query.append("WHERE MDM.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("  AND MDM.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("  AND 'L' = @[loc_type_cd]" ).append("\n"); 
		query.append("  AND MDM.LOC_CD = EXPT.EXPT_LOC_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT MDM.LOC_CD, DECODE(PRC_IHC_ONY_FLG, 'Y', 'N', MDM.CALL_PORT_FLG) CALL_PORT_FLG--exception 테이블의 IHC Only flag가 'Y' 이면 call port flag를 N 으로 return" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_GRP_LOC LOC" ).append("\n"); 
		query.append("    ,PRI_RP_SCP_GRP_LOC_DTL DTL" ).append("\n"); 
		query.append("    ,MDM_LOCATION MDM " ).append("\n"); 
		query.append("    ,PRI_TRF_IHC_EXPT_CY_LOC EXPT" ).append("\n"); 
		query.append("WHERE LOC.PROP_NO = DTL.PROP_NO" ).append("\n"); 
		query.append("  AND LOC.AMDT_SEQ = DTL.AMDT_SEQ" ).append("\n"); 
		query.append("  AND LOC.SVC_SCP_CD = DTL.SVC_SCP_CD" ).append("\n"); 
		query.append("  AND LOC.GRP_LOC_SEQ = DTL.GRP_LOC_SEQ" ).append("\n"); 
		query.append("  AND LOC.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("  AND LOC.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("  AND LOC.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("  AND LOC.ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("  AND LOC.PRC_GRP_LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("  AND DTL.LOC_CD = MDM.LOC_CD" ).append("\n"); 
		query.append("  AND 'G' = @[loc_type_cd]" ).append("\n"); 
		query.append("  AND MDM.LOC_CD = EXPT.EXPT_LOC_CD(+)" ).append("\n"); 

	}
}