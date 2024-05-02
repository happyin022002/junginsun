/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCProposalMainDBDAOInitCancelChssEffDtCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCProposalMainDBDAOInitCancelChssEffDtCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * init Cancel시 CHSS 데이터를 조회한다.
	  * 2013.10.21 전윤주 [CHM-201327107] 최초 생성
	  * 2014.04.03 전윤주 [CHM-201429648] CHSS Conversion data의 status에 관계 없이 conversion이 존재하면 삭제 못함 
	  *                                                       (conversion delete 먼저 해야함)
	  * </pre>
	  */
	public SCProposalMainDBDAOInitCancelChssEffDtCheckVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration").append("\n"); 
		query.append("FileName : SCProposalMainDBDAOInitCancelChssEffDtCheckVORSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) ETC1" ).append("\n"); 
		query.append("  FROM CGM_SC_EXPT_VER A1, PRI_SP_MN A2" ).append("\n"); 
		query.append(" WHERE A1.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("   AND SC_EXPT_VER_SEQ = (SELECT /*+ INDEX_DESC(A XPKCGM_SC_EXPT_VER) */" ).append("\n"); 
		query.append("                                SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("                           FROM CGM_SC_EXPT_VER A" ).append("\n"); 
		query.append("                          WHERE PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                            AND ROWNUM = 1)" ).append("\n"); 
		query.append("  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(" -- AND CHSS_EXPT_VER_STS_CD IN ('A','L','R')" ).append("\n"); 
		query.append("  AND A1.PROP_NO = A2.PROP_NO" ).append("\n"); 
		query.append("  AND A2.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("  AND A1.EFF_DT = A2.EFF_DT -- CGM은 EFF DT를 입력할 수 없으므로 현재 EFF DT와 같은 EFF DT의 Exception이 있으면 이번 회차에 새로 생성된 것이 있는 것임" ).append("\n"); 

	}
}