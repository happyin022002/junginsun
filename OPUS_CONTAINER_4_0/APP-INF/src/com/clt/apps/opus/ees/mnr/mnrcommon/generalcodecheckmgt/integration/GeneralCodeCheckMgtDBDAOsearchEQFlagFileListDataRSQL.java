/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOsearchEQFlagFileListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.12.16 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOsearchEQFlagFileListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEQFlagFileListData
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOsearchEQFlagFileListDataRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOsearchEQFlagFileListDataRSQL").append("\n"); 
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
		query.append("DECODE(A.INP_MSG4,'SS',1,0) AS CHECKBOX" ).append("\n"); 
		query.append("FROM MNR_DAT_VRFY A,MNR_EQ_STS_V C," ).append("\n"); 
		query.append("(SELECT MNR_CD_ID, MNR_CD_DP_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD" ).append("\n"); 
		query.append("WHERE PRNT_CD_ID = 'CD00004') B" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq] AND A.INP_MSG4 = B.MNR_CD_ID(+)" ).append("\n"); 
		query.append("AND A.INP_MSG1 = C.EQ_NO(+)" ).append("\n"); 

	}
}