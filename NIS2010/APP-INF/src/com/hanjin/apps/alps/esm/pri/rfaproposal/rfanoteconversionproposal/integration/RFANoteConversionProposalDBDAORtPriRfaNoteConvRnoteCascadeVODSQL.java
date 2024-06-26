/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFANoteConversionProposalDBDAORtPriRfaNoteConvRnoteCascadeVODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFANoteConversionProposalDBDAORtPriRfaNoteConvRnoteCascadeVODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ROUTE NOTE CONVERSION을 삭제한다.
	  * - 20100805 : IS_DEL_AMEND 부분 수정 - IN 쿼리에 'AM'을 추가함
	  * </pre>
	  */
	public RFANoteConversionProposalDBDAORtPriRfaNoteConvRnoteCascadeVODSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_note_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration").append("\n"); 
		query.append("FileName : RFANoteConversionProposalDBDAORtPriRfaNoteConvRnoteCascadeVODSQL").append("\n"); 
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
		query.append("DELETE FROM PRI_RFA_NOTE_CONV A" ).append("\n"); 
		query.append(" WHERE NOTE_CONV_TP_CD = 'R'" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_RT_CMDT_RNOTE" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("           AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${CASCADE_LEVEL} == '0') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == '1') " ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == '2') " ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("           AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("#elseif (${CASCADE_LEVEL} == '3') " ).append("\n"); 
		query.append("           AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("           AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("           AND ROUT_NOTE_SEQ = @[rout_note_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${IS_MASTER} != 'Y') " ).append("\n"); 
		query.append("#if (${IS_DEL_AMEND} == 'Y') " ).append("\n"); 
		query.append("           AND SRC_INFO_CD IN ('NW', 'GC', 'GM', 'PC', 'PM', 'AM')" ).append("\n"); 
		query.append("           --AND PRC_PROG_STS_CD = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("-- Master RFA" ).append("\n"); 
		query.append("           AND SRC_INFO_CD IN ('NW', 'GC', 'GM', 'PC', 'PM')" ).append("\n"); 
		query.append("           AND PRC_PROG_STS_CD = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND NOTE_CONV_MAPG_ID = A.NOTE_CONV_MAPG_ID)" ).append("\n"); 

	}
}