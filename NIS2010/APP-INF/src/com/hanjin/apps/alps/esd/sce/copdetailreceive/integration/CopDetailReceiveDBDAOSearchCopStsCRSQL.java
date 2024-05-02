/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCopStsCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.03 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchCopStsCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopStsC
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCopStsCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inCrntSkdVoyNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pActRcvTpCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inMvmtStsCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inCrntSkdDirCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inCrntVslCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inOrgYdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inCopNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCopStsCRSQL").append("\n"); 
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
		query.append("SELECT A.COP_NO" ).append("\n"); 
		query.append(",A.COP_DTL_SEQ" ).append("\n"); 
		query.append(",A.NOD_CD" ).append("\n"); 
		query.append(",A.ACT_STS_CD" ).append("\n"); 
		query.append(",B.ACT_RCV_TP_CD" ).append("\n"); 
		query.append(",B.ACT_STS_MAPG_CD" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.STND_EDI_STS_CD" ).append("\n"); 
		query.append(",A.ACT_STS_CD" ).append("\n"); 
		query.append(",A.ACT_CD" ).append("\n"); 
		query.append(",( CASE WHEN @[inMvmtStsCd] = 'VL' AND (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) IN ( (@[inCrntVslCd],@[inCrntSkdVoyNo], @[inCrntSkdDirCd]))" ).append("\n"); 
		query.append("AND ACT_STS_CD = 'C' THEN '1'" ).append("\n"); 
		query.append("WHEN @[inMvmtStsCd] = 'VL' AND (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) IN ( (@[inCrntVslCd], @[inCrntSkdVoyNo], @[inCrntSkdDirCd]))" ).append("\n"); 
		query.append("AND ACT_STS_CD != 'C' THEN '2'" ).append("\n"); 
		query.append("WHEN @[inMvmtStsCd] = 'VL' AND (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) NOT IN ( (@[inCrntVslCd], @[inCrntSkdVoyNo], @[inCrntSkdDirCd]))" ).append("\n"); 
		query.append("AND ACT_STS_CD = 'C' THEN '3'" ).append("\n"); 
		query.append("WHEN @[inMvmtStsCd] = 'VL' AND (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) NOT IN ( (@[inCrntVslCd], @[inCrntSkdVoyNo], @[inCrntSkdDirCd]))" ).append("\n"); 
		query.append("AND ACT_STS_CD != 'C' THEN '4'" ).append("\n"); 
		query.append("WHEN ((@[inMvmtStsCd] = 'VL' AND @[inCrntVslCd] = '' AND @[inCrntSkdVoyNo] = '' AND @[inCrntSkdDirCd] = '') OR @[inMvmtStsCd] != 'VL')" ).append("\n"); 
		query.append("AND ACT_STS_CD = 'C' THEN '5'" ).append("\n"); 
		query.append("WHEN ((@[inMvmtStsCd] = 'VL' AND @[inCrntVslCd] = '' AND @[inCrntSkdVoyNo] = '' AND @[inCrntSkdDirCd] = '') OR @[inMvmtStsCd] != 'VL')" ).append("\n"); 
		query.append("AND ACT_STS_CD != 'C' THEN '6'" ).append("\n"); 
		query.append("ELSE '7' END ) AS LVL" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL A" ).append("\n"); 
		query.append(",SCE_ACT_ACT_MAPG B" ).append("\n"); 
		query.append("WHERE  A.COP_NO          = @[inCopNo]" ).append("\n"); 
		query.append("AND ACT_STS_CD = 'C'" ).append("\n"); 
		query.append("AND    CASE WHEN @[inMvmtStsCd] = 'VL' AND (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD) IN ( (@[inCrntVslCd], @[inCrntSkdVoyNo], @[inCrntSkdDirCd])) THEN 'TRUE'" ).append("\n"); 
		query.append("WHEN @[inMvmtStsCd] != 'VL' THEN 'TRUE'" ).append("\n"); 
		query.append("ELSE 'FALSE' END = 'TRUE'" ).append("\n"); 
		query.append("AND    (" ).append("\n"); 
		query.append("(DECODE(  B.ACT_STS_MAPG_CD, 'VL', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'VD', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'AL', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'UR', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'AR', DECODE(SUBSTR(A.NOD_CD,1,2),'US',SUBSTR(A.NOD_CD, 1, 5),'CA',SUBSTR(A.NOD_CD, 1, 5), A.NOD_CD)," ).append("\n"); 
		query.append("'RL', DECODE(SUBSTR(A.NOD_CD,1,2),'US',SUBSTR(A.NOD_CD, 1, 5),'CA',SUBSTR(A.NOD_CD, 1, 5), A.NOD_CD)," ).append("\n"); 
		query.append("A.NOD_CD)" ).append("\n"); 
		query.append("= DECODE(@[inMvmtStsCd]," ).append("\n"); 
		query.append("'VL', SUBSTR(@[inOrgYdCd], 1, 5)," ).append("\n"); 
		query.append("'VD', SUBSTR(@[inOrgYdCd], 1, 5)," ).append("\n"); 
		query.append("'AL', SUBSTR(@[inOrgYdCd], 1, 5)," ).append("\n"); 
		query.append("'UR', SUBSTR(@[inOrgYdCd], 1, 5)," ).append("\n"); 
		query.append("'AR', DECODE(SUBSTR(@[inOrgYdCd],1,2),'US',SUBSTR(@[inOrgYdCd], 1, 5),'CA',SUBSTR(A.NOD_CD, 1, 5), @[inOrgYdCd])," ).append("\n"); 
		query.append("'RL', DECODE(SUBSTR(@[inOrgYdCd],1,2),'US',SUBSTR(@[inOrgYdCd], 1, 5),'CA',SUBSTR(A.NOD_CD, 1, 5), @[inOrgYdCd])," ).append("\n"); 
		query.append("@[inOrgYdCd])" ).append("\n"); 
		query.append(") OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("A.COP_DTL_SEQ > 6000" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("DECODE(B.ACT_STS_MAPG_CD, 'IC', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'ID', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'EN', SUBSTR(A.NOD_CD, 1, 5)," ).append("\n"); 
		query.append("'TN', SUBSTR(A.NOD_CD, 1, 5), A.NOD_CD )" ).append("\n"); 
		query.append("= DECODE(@[inMvmtStsCd], 'IC', SUBSTR(@[inOrgYdCd], 1, 5)," ).append("\n"); 
		query.append("'ID', SUBSTR(@[inOrgYdCd], 1, 5)," ).append("\n"); 
		query.append("'EN', SUBSTR(@[inOrgYdCd], 1, 5)," ).append("\n"); 
		query.append("'TN', SUBSTR(@[inOrgYdCd], 1, 5), @[inOrgYdCd])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND    A.ACT_CD          = B.ACT_CD" ).append("\n"); 
		query.append("AND    B.ACT_RCV_TP_CD   = @[pActRcvTpCd]" ).append("\n"); 
		query.append("AND    B.ACT_STS_MAPG_CD = @[inMvmtStsCd]" ).append("\n"); 
		query.append("ORDER BY LVL, A.COP_DTL_SEQ" ).append("\n"); 

	}
}