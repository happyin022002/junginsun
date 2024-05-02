/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TAAProposalDBDAOsearchEmailTargetUserListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.19
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2012.09.19 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TAAProposalDBDAOsearchEmailTargetUserListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2012.09.18 원종규 [CHM-201220110-01] 계약 변경 통보 기능-계약이 사용된 BKG에대해 BKG의 Rating을 진행한 유저에게  G/W 메일 발송
	  * </pre>
	  */
	public TAAProposalDBDAOsearchEmailTargetUserListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("taa_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.integration").append("\n"); 
		query.append("FileName : TAAProposalDBDAOsearchEmailTargetUserListRSQL").append("\n"); 
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
		query.append("SELECT ROW_NUMBER() OVER(ORDER BY A.UPD_USR_ID, A.BKG_NO) SEQ" ).append("\n"); 
		query.append("	  ,A.BKG_NO" ).append("\n"); 
		query.append("      ,A.TAA_NO" ).append("\n"); 
		query.append("      ,A.RT_APLY_DT" ).append("\n"); 
		query.append("      ,A.EFF_DT" ).append("\n"); 
		query.append("      ,A.HIS_DTL_SEQ" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,B.USR_NM" ).append("\n"); 
		query.append("      ,B.USR_EML" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("       A1.BKG_NO" ).append("\n"); 
		query.append("      ,A1.TAA_NO" ).append("\n"); 
		query.append("      ,A2.RT_APLY_DT" ).append("\n"); 
		query.append("      ,A1.SVC_SCP_CD" ).append("\n"); 
		query.append("      ,A4.EFF_DT" ).append("\n"); 
		query.append("      ,MAX(A5.HIS_DTL_SEQ) OVER (PARTITION BY A5.BKG_NO) MAX_HIS_DTL_SEQ" ).append("\n"); 
		query.append("      ,A5.HIS_DTL_SEQ" ).append("\n"); 
		query.append("      ,A5.UPD_USR_ID" ).append("\n"); 
		query.append("    FROM BKG_BOOKING A1" ).append("\n"); 
		query.append("        ,BKG_RATE A2" ).append("\n"); 
		query.append("        ,PRI_TAA_HDR A3" ).append("\n"); 
		query.append("        ,PRI_TAA_MN A4" ).append("\n"); 
		query.append("        ,BKG_HIS_DTL A5" ).append("\n"); 
		query.append("    WHERE A1.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("      AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("      AND A1.TAA_NO = A3.TAA_NO" ).append("\n"); 
		query.append("      AND A3.TAA_PROP_NO = A4.TAA_PROP_NO" ).append("\n"); 
		query.append("      AND A4.TAA_PROP_NO = @[taa_prop_no]  -- confirm 대상 TAA PROP NO" ).append("\n"); 
		query.append("      AND A4.AMDT_SEQ = @[amdt_seq] -- confirm 대상 TAA Amend No            " ).append("\n"); 
		query.append("      AND A4.SVC_SCP_CD = A1.SVC_SCP_CD" ).append("\n"); 
		query.append("      AND (A2.RT_APLY_DT BETWEEN A4.EFF_DT AND A4.EXP_DT --confirm 한 TAA의 effective date 이후에 application date가 존재하는 경우" ).append("\n"); 
		query.append("          OR A4.EXP_DT <A2.RT_APLY_DT) -- confirm 한 TAA의 exp date 이후에 rate 날짜가 있는 경우 -- 적용 TAA가 없어지면서 다시 rating 해야 함" ).append("\n"); 
		query.append("      AND A1.BKG_NO = A5.BKG_NO" ).append("\n"); 
		query.append("      AND A5.HIS_CATE_NM = 'CHARGE DETAIL') A --history 중 rating 한 경우만 추출" ).append("\n"); 
		query.append("      ,COM_USER B" ).append("\n"); 
		query.append("WHERE A.MAX_HIS_DTL_SEQ = A.HIS_DTL_SEQ  -- 가장 마지막 rate 한 user 추출" ).append("\n"); 
		query.append("AND A.UPD_USR_ID = B.USR_ID" ).append("\n"); 

	}
}