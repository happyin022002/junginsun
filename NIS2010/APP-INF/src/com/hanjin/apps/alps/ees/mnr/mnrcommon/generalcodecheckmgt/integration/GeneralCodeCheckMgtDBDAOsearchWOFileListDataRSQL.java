/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOsearchWOFileListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.12.15 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungBuebKwon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOsearchWOFileListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mnr_dat_vrfy 테이블을 조회한다.
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOsearchWOFileListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOsearchWOFileListDataRSQL").append("\n"); 
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
		query.append("SELECT A.TMP_SEQ," ).append("\n"); 
		query.append("A.TMP_DTL_SEQ," ).append("\n"); 
		query.append("A.INP_MSG1," ).append("\n"); 
		query.append("A.INP_MSG2," ).append("\n"); 
		query.append("A.INP_MSG3," ).append("\n"); 
		query.append("A.INP_MSG4," ).append("\n"); 
		query.append("B.MNR_CD_DP_DESC AS INP_MSG5," ).append("\n"); 
		query.append("C.EQ_TPSZ_CD  AS INP_MSG6," ).append("\n"); 
		query.append("C.RPR_YD  AS INP_MSG7," ).append("\n"); 
		query.append("C.RPR_DT  AS INP_MSG8," ).append("\n"); 
		query.append("C.SP_NAME  AS INP_MSG9," ).append("\n"); 
		query.append("DECODE(A.INP_MSG4,'SS',1,0) AS CHECKBOX" ).append("\n"); 
		query.append("FROM MNR_DAT_VRFY A,MNR_EQ_STS_V C," ).append("\n"); 
		query.append("(SELECT MNR_CD_ID, MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID = 'CD00004') B" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq] AND A.INP_MSG4 = B.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND A.INP_MSG1 = C.EQ_NO(+)" ).append("\n"); 

	}
}