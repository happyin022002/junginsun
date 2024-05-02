/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDDAOSearchEdiEdoGenresMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.10.19 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim JinYoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDDAOSearchEdiEdoGenresMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDO 전송을 위한 메인 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDDAOSearchEdiEdoGenresMstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ack_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_rjct_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDDAOSearchEdiEdoGenresMstRSQL").append("\n"); 
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
		query.append("SELECT '{E_MAIN'                                                   || CHR(10)" ).append("\n"); 
		query.append("||'MSG_REQ_NO:'  || @[rqst_no]                               || CHR(10)" ).append("\n"); 
		query.append("||'MSG_REQ_FLAG:'|| DECODE(MST.EDO_ACK_CD,NULL, '9','35')    || CHR(10)" ).append("\n"); 
		query.append("||'MSG_TP_FLAG:' || @[edo_tp_cd]                             || CHR(10)    -- '5JN' or '5JK' or '5JM'" ).append("\n"); 
		query.append("||'MSG_ACK_TP:'  || @[ack_cd]                                || CHR(10)    -- 'A' or 'R'" ).append("\n"); 
		query.append("||'MSG_ACK_DT:'  || TO_CHAR(sysdate, 'YYYYMMDDHH24MISS')     || CHR(10)" ).append("\n"); 
		query.append("||'MSG_R_REASON:'|| decode(@[ack_cd],'R',@[edo_rjct_rsn],'') || CHR(10)" ).append("\n"); 
		query.append("||'}E_MAIN'                                                  || CHR(10)" ).append("\n"); 
		query.append("AS EDI_GENRES_MST" ).append("\n"); 
		query.append("FROM BKG_EDO_MST MST" ).append("\n"); 
		query.append(",( SELECT @[rqst_no]                 AS EDO_RQST_NO" ).append("\n"); 
		query.append(",nvl(Max(EDO_RQST_SEQ), 1)   AS EDO_RQST_SEQ" ).append("\n"); 
		query.append("FROM BKG_EDO_MST" ).append("\n"); 
		query.append("WHERE EDO_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND EDO_TP_CD   = @[edo_tp_cd]" ).append("\n"); 
		query.append(") SUB" ).append("\n"); 
		query.append("WHERE MST.EDO_RQST_NO = SUB.EDO_RQST_NO" ).append("\n"); 
		query.append("AND MST.EDO_RQST_SEQ = SUB.EDO_RQST_SEQ" ).append("\n"); 

	}
}