/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFAProposalMainDBDAOPriRpRetroVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.11.26 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sunghwan Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAProposalMainDBDAOPriRpRetroVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA의 Creation Date가 Rate Column의 Effective Date보다 늦을 경우, 승인권자가 Approval Click 이후 Save 이전 단계에서, 
	  * Retroactive RFA임을 알고 해당 사유를 선택하여 저장하는 기능
	  * </pre>
	  */
	public RFAProposalMainDBDAOPriRpRetroVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtro_note_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtro_note_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.integration").append("\n"); 
		query.append("FileName : RFAProposalMainDBDAOPriRpRetroVOCSQL").append("\n"); 
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
		query.append("MERGE		" ).append("\n"); 
		query.append("  INTO PRI_RP_RTRO_NOTE T 		" ).append("\n"); 
		query.append(" USING (SELECT *		" ).append("\n"); 
		query.append("          FROM PRI_RP_MN		" ).append("\n"); 
		query.append("         WHERE PROP_NO = @[prop_no]		" ).append("\n"); 
		query.append("           AND AMDT_SEQ = @[amdt_seq]		" ).append("\n"); 
		query.append("        ) S 		" ).append("\n"); 
		query.append("        ON ( T.PROP_NO = S.PROP_NO		" ).append("\n"); 
		query.append("         AND T.AMDT_SEQ = S.AMDT_SEQ		" ).append("\n"); 
		query.append("         AND T.RTRO_NOTE_SEQ = 1" ).append("\n"); 
		query.append("            )		" ).append("\n"); 
		query.append("WHEN MATCHED THEN		" ).append("\n"); 
		query.append("UPDATE		" ).append("\n"); 
		query.append("   	 SET T.RTRO_NOTE_CD = @[rtro_note_cd]		" ).append("\n"); 
		query.append("     	,T.RTRO_NOTE_CTNT = nvl(@[rtro_note_ctnt], '')" ).append("\n"); 
		query.append("        ,T.RTRO_NOTE_CRE_DT = SYSDATE		" ).append("\n"); 
		query.append("     	,T.UPD_USR_ID = @[upd_usr_id]	" ).append("\n"); 
		query.append("     	,T.UPD_DT = SYSDATE		" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN		" ).append("\n"); 
		query.append("	  INSERT (T.PROP_NO		" ).append("\n"); 
		query.append("             , T.AMDT_SEQ		" ).append("\n"); 
		query.append("             , T.RTRO_NOTE_SEQ		" ).append("\n"); 
		query.append("             , T.RTRO_NOTE_CD		" ).append("\n"); 
		query.append("             , T.RTRO_NOTE_CTNT		" ).append("\n"); 
		query.append("             , T.RTRO_NOTE_CRE_DT		" ).append("\n"); 
		query.append("             , T.CRE_USR_ID		" ).append("\n"); 
		query.append("             , T.CRE_DT		" ).append("\n"); 
		query.append("             , T.UPD_USR_ID		" ).append("\n"); 
		query.append("             , T.UPD_DT)		" ).append("\n"); 
		query.append("	   VALUES (@[prop_no]" ).append("\n"); 
		query.append("             , @[amdt_seq]" ).append("\n"); 
		query.append("             , 1		" ).append("\n"); 
		query.append("             , @[rtro_note_cd]	" ).append("\n"); 
		query.append("             , nvl(@[rtro_note_ctnt], '')" ).append("\n"); 
		query.append("             , SYSDATE		" ).append("\n"); 
		query.append("             , @[cre_usr_id]" ).append("\n"); 
		query.append("             , SYSDATE		" ).append("\n"); 
		query.append("             , @[upd_usr_id]" ).append("\n"); 
		query.append("             , SYSDATE)" ).append("\n"); 

	}
}