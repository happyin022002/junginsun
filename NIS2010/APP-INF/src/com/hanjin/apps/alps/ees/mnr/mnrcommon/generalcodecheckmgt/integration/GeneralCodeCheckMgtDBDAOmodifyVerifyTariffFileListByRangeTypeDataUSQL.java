/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByRangeTypeDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.12.15 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByRangeTypeDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정 - Tariff File Verify RangeType
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByRangeTypeDataUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByRangeTypeDataUSQL").append("\n"); 
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
		query.append("SET A.INP_MSG4 = 'RT'" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND A.INP_MSG4 = 'SS'" ).append("\n"); 
		query.append("AND NVL(A.INP_MSG10,' ') <> 'F'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT *" ).append("\n"); 
		query.append("FROM MNR_DAT_VRFY B" ).append("\n"); 
		query.append("WHERE B.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND A.INP_MSG1 = B.INP_MSG1" ).append("\n"); 
		query.append("AND A.INP_MSG2 = B.INP_MSG2" ).append("\n"); 
		query.append("AND NVL(A.INP_MSG6,' ') = NVL(B.INP_MSG6,' ')" ).append("\n"); 
		query.append("AND NVL(A.INP_MSG8,0) = NVL(B.INP_MSG8,0)" ).append("\n"); 
		query.append("AND NVL(A.INP_MSG9,0) = NVL(B.INP_MSG9,0)" ).append("\n"); 
		query.append("AND A.INP_MSG17 = B.INP_MSG17" ).append("\n"); 
		query.append("AND B.INP_MSG10 = 'F')" ).append("\n"); 

	}
}