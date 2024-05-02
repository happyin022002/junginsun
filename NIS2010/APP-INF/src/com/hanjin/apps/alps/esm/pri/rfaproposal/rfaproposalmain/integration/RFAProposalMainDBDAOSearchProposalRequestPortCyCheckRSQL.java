/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RFAProposalMainDBDAOSearchProposalRequestPortCyCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOSearchProposalRequestPortCyCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.07.08 전윤주 [CHM-201324601] RFA Request 시 Port 운임에 속한 Route (Origin, Dest) 를 체크하여 call_port_flag가 'N' 인 경우 validation 처리 
	  *                                                      Port CY 운임에 Port 가 아닌 Route가 존재하는지 체크 - MDM 에 Call_port_flg 컬럼을 확인한다.
	  * 2013.09.13 전윤주 [CHM-201326757] Group Location이 Both로 등록된 경우도 체크하도록 수정
	  * 2013.09.16 전윤주 [CHM-201326776] RFA Request 체크 시 예외 location 테이블에 IHC Only flag도 체크하여 에러로 리턴해주는 로직 추가
	  * </pre>
	  */
	public RFAProposalMainDBDAOSearchProposalRequestPortCyCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOSearchProposalRequestPortCyCheckRSQL").append("\n"); 
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
		query.append("SELECT A1.SVC_SCP_CD ||'-'|| " ).append("\n"); 
		query.append("     'Bullet No.'||A2.BLET_DP_SEQ || '-'||" ).append("\n"); 
		query.append("      DECODE(A1.ORG_DEST_TP_CD, 'O', 'Origin', 'Dest.')|| '-' ||" ).append("\n"); 
		query.append("      A1.ROUT_PNT_LOC_DEF_CD AS ETC1" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_PNT A1" ).append("\n"); 
		query.append("    ,PRI_RP_SCP_RT_CMDT_HDR A2" ).append("\n"); 
		query.append("WHERE A1.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A1.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A1.SVC_SCP_CD NOT IN ('TPE','TPW','ACE','ACW','TAE','TAW','ASE','ASW','MMW','MME','SAN','SAS','CAN','CAS','CSE','CME','MWS','MWN','CCS','CCN','CLN','CLS') -- PORT CY, IHC RATE 구분하지 않는 예외 SCOPE" ).append("\n"); 
		query.append("AND A1.ROUT_PNT_LOC_DEF_CD IN (" ).append("\n"); 
		query.append("                               SELECT  GC.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("                                 FROM  PRI_RP_SCP_GRP_LOC GC  " ).append("\n"); 
		query.append("                                      ,PRI_RP_SCP_GRP_LOC_DTL GD" ).append("\n"); 
		query.append("                                      ,MDM_LOCATION           MD" ).append("\n"); 
		query.append("                                WHERE GD.PROP_NO          = GC.PROP_NO" ).append("\n"); 
		query.append("                                  AND GD.AMDT_SEQ         = GC.AMDT_SEQ" ).append("\n"); 
		query.append("                                  AND GD.SVC_SCP_CD       = GC.SVC_SCP_CD" ).append("\n"); 
		query.append("                                  AND GD.GRP_LOC_SEQ      = GC.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                                  AND GD.SRC_INFO_CD      <> 'AD'" ).append("\n"); 
		query.append("                                  AND GC.PROP_NO          = A1.PROP_NO" ).append("\n"); 
		query.append("                                  AND GC.AMDT_SEQ         = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                  AND GC.SVC_SCP_CD       = A1.SVC_SCP_CD" ).append("\n"); 
		query.append("                                  AND DECODE(GC.ORG_DEST_TP_CD, 'B', A1.ORG_DEST_TP_CD,  GC.ORG_DEST_TP_CD)  = A1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                  AND GD.LOC_CD           = MD.LOC_CD" ).append("\n"); 
		query.append("                                  AND MD.CALL_PORT_FLG = 'N'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("AND A1.ROUT_PNT_LOC_TP_CD = 'G' -- Group location 일 경우 " ).append("\n"); 
		query.append("AND A1.PROP_NO = A2.PROP_NO" ).append("\n"); 
		query.append("AND A1.AMDT_SEQ = A2.AMDT_SEQ" ).append("\n"); 
		query.append("AND A1.SVC_SCP_CD = A2.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A1.CMDT_HDR_SEQ = A2.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND A2.FIC_RT_TP_CD = 'G' -- Port CY 운임인 경우" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT A1.SVC_SCP_CD || '-' ||" ).append("\n"); 
		query.append("      'Bullet No.'||A3.BLET_DP_SEQ || '-' ||" ).append("\n"); 
		query.append("       DECODE(A1.ORG_DEST_TP_CD, 'O', 'Origin', 'Dest.')|| '-' ||" ).append("\n"); 
		query.append("       A1.ROUT_PNT_LOC_DEF_CD AS ETC1" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_PNT A1" ).append("\n"); 
		query.append("    ,MDM_LOCATION A2" ).append("\n"); 
		query.append("    ,PRI_RP_SCP_RT_CMDT_HDR A3" ).append("\n"); 
		query.append("WHERE A1.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A1.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A1.SVC_SCP_CD NOT IN ('TPE','TPW','ACE','ACW','TAE','TAW','ASE','ASW','MMW','MME','SAN','SAS','CAN','CAS','CSE','CME','MWS','MWN','CCS','CCN','CLN','CLS') -- PORT CY, IHC RATE 구분하지 않는 예외 SCOPE" ).append("\n"); 
		query.append("AND A1.ROUT_PNT_LOC_DEF_CD = A2.LOC_CD" ).append("\n"); 
		query.append("AND A2.CALL_PORT_FLG = 'N'" ).append("\n"); 
		query.append("AND A1.SRC_INFO_CD      <> 'AD'" ).append("\n"); 
		query.append("AND A1.ROUT_PNT_LOC_TP_CD = 'L' -- Location으로 입력된 경우 " ).append("\n"); 
		query.append("AND A1.PROP_NO = A3.PROP_NO" ).append("\n"); 
		query.append("AND A1.AMDT_SEQ = A3.AMDT_SEQ" ).append("\n"); 
		query.append("AND A1.SVC_SCP_CD = A3.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A1.CMDT_HDR_SEQ = A3.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND A3.FIC_RT_TP_CD = 'G' -- Port CY 운임인 경우" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT A1.SVC_SCP_CD ||'-'|| " ).append("\n"); 
		query.append("     'Bullet No.'||A2.BLET_DP_SEQ || '-'||" ).append("\n"); 
		query.append("      DECODE(A1.ORG_DEST_TP_CD, 'O', 'Origin', 'Dest.')|| '-' ||" ).append("\n"); 
		query.append("      A1.ROUT_PNT_LOC_DEF_CD AS ETC1" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_PNT A1" ).append("\n"); 
		query.append("    ,PRI_RP_SCP_RT_CMDT_HDR A2" ).append("\n"); 
		query.append("WHERE A1.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A1.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A1.SVC_SCP_CD NOT IN ('TPE','TPW','ACE','ACW','TAE','TAW','ASE','ASW','MMW','MME','SAN','SAS','CAN','CAS','CSE','CME','MWS','MWN','CCS','CCN','CLN','CLS') -- PORT CY, IHC RATE 구분하지 않는 예외 SCOPE" ).append("\n"); 
		query.append("AND A1.ROUT_PNT_LOC_DEF_CD IN (" ).append("\n"); 
		query.append("                               SELECT  GC.PRC_GRP_LOC_CD" ).append("\n"); 
		query.append("                                 FROM  PRI_RP_SCP_GRP_LOC GC  " ).append("\n"); 
		query.append("                                      ,PRI_RP_SCP_GRP_LOC_DTL GD" ).append("\n"); 
		query.append("                                      ,PRI_TRF_IHC_EXPT_CY_LOC   EX" ).append("\n"); 
		query.append("                                WHERE GD.PROP_NO          = GC.PROP_NO" ).append("\n"); 
		query.append("                                  AND GD.AMDT_SEQ         = GC.AMDT_SEQ" ).append("\n"); 
		query.append("                                  AND GD.SVC_SCP_CD       = GC.SVC_SCP_CD" ).append("\n"); 
		query.append("                                  AND GD.GRP_LOC_SEQ      = GC.GRP_LOC_SEQ" ).append("\n"); 
		query.append("                                  AND GD.SRC_INFO_CD      <> 'AD'" ).append("\n"); 
		query.append("                                  AND GC.PROP_NO          = A1.PROP_NO" ).append("\n"); 
		query.append("                                  AND GC.AMDT_SEQ         = A1.AMDT_SEQ" ).append("\n"); 
		query.append("                                  AND GC.SVC_SCP_CD       = A1.SVC_SCP_CD" ).append("\n"); 
		query.append("                                  AND DECODE(GC.ORG_DEST_TP_CD, 'B', A1.ORG_DEST_TP_CD,  GC.ORG_DEST_TP_CD)  = A1.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                  AND GD.SVC_SCP_CD       = EX.SVC_SCP_CD" ).append("\n"); 
		query.append("                                  AND DECODE(GC.ORG_DEST_TP_CD, 'B', EX.ORG_DEST_TP_CD,  GC.ORG_DEST_TP_CD)  = EX.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("                                  AND GD.LOC_CD           = EX.EXPT_LOC_CD" ).append("\n"); 
		query.append("                                  AND EX.PRC_IHC_ONY_FLG = 'Y'  --PORT Flag가 Y 이나 IHC에만 넣어야 하는 예외 Location 에 있는 경우 걸러냄" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("AND A1.ROUT_PNT_LOC_TP_CD = 'G' -- Group location 일 경우 " ).append("\n"); 
		query.append("AND A1.PROP_NO = A2.PROP_NO" ).append("\n"); 
		query.append("AND A1.AMDT_SEQ = A2.AMDT_SEQ" ).append("\n"); 
		query.append("AND A1.SVC_SCP_CD = A2.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A1.CMDT_HDR_SEQ = A2.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND A2.FIC_RT_TP_CD = 'G' -- Port CY 운임인 경우" ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT A1.SVC_SCP_CD || '-' ||" ).append("\n"); 
		query.append("      'Bullet No.'||A3.BLET_DP_SEQ || '-' ||" ).append("\n"); 
		query.append("       DECODE(A1.ORG_DEST_TP_CD, 'O', 'Origin', 'Dest.')|| '-' ||" ).append("\n"); 
		query.append("       A1.ROUT_PNT_LOC_DEF_CD AS ETC1" ).append("\n"); 
		query.append("FROM PRI_RP_SCP_RT_ROUT_PNT A1" ).append("\n"); 
		query.append("    ,PRI_TRF_IHC_EXPT_CY_LOC A2" ).append("\n"); 
		query.append("    ,PRI_RP_SCP_RT_CMDT_HDR A3" ).append("\n"); 
		query.append("WHERE A1.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("AND A1.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("AND A1.SVC_SCP_CD NOT IN ('TPE','TPW','ACE','ACW','TAE','TAW','ASE','ASW','MMW','MME','SAN','SAS','CAN','CAS','CSE','CME','MWS','MWN','CCS','CCN','CLN','CLS') -- PORT CY, IHC RATE 구분하지 않는 예외 SCOPE" ).append("\n"); 
		query.append("AND A1.SVC_SCP_CD      = A2.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A1.ORG_DEST_TP_CD  = A2.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("AND A1.ROUT_PNT_LOC_DEF_CD  = A2.EXPT_LOC_CD" ).append("\n"); 
		query.append("AND A2.PRC_IHC_ONY_FLG = 'Y' --PORT Flag가 Y 이나 IHC에만 넣어야 하는 예외 Location 에 있는 경우 걸러냄" ).append("\n"); 
		query.append("AND A1.SRC_INFO_CD      <> 'AD'" ).append("\n"); 
		query.append("AND A1.ROUT_PNT_LOC_TP_CD = 'L' -- Location으로 입력된 경우 " ).append("\n"); 
		query.append("AND A1.PROP_NO = A3.PROP_NO" ).append("\n"); 
		query.append("AND A1.AMDT_SEQ = A3.AMDT_SEQ" ).append("\n"); 
		query.append("AND A1.SVC_SCP_CD = A3.SVC_SCP_CD" ).append("\n"); 
		query.append("AND A1.CMDT_HDR_SEQ = A3.CMDT_HDR_SEQ" ).append("\n"); 
		query.append("AND A3.FIC_RT_TP_CD = 'G' -- Port CY 운임인 경우" ).append("\n"); 

	}
}