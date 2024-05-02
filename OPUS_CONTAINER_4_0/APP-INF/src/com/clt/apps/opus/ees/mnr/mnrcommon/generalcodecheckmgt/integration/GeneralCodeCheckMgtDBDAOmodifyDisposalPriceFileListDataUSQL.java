/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyDisposalPriceFileListDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.12.15 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungBuebKwon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyDisposalPriceFileListDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOCATION OR OFFICE CD로 벨리데이션 체크
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyDisposalPriceFileListDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inp_msg1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyDisposalPriceFileListDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DAT_VRFY A" ).append("\n"); 
		query.append("SET INP_MSG4 = DECODE(@[inp_msg1],'CNT', 'LE','UO')" ).append("\n"); 
		query.append("WHERE TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND  TMP_DTL_SEQ = @[tmp_dtl_seq]" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN (@[inp_msg1] = 'CNT')" ).append("\n"); 
		query.append("THEN(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("D.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION D, MDM_COUNTRY B, MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("WHERE 1 = 1 AND D.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("AND D.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("AND NVL(D.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND A.INP_MSG2 = D.LOC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN (@[inp_msg1] = 'RHQ')" ).append("\n"); 
		query.append("THEN(" ).append("\n"); 
		query.append("SELECT  B.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND B.OFC_KND_CD='2'" ).append("\n"); 
		query.append("AND A.INP_MSG2 = B.OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN (@[inp_msg1] = 'OFC')" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  B.OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND B.OFC_KND_CD <> '2'" ).append("\n"); 
		query.append("AND A.INP_MSG2 = B.OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") IS NULL" ).append("\n"); 

	}
}