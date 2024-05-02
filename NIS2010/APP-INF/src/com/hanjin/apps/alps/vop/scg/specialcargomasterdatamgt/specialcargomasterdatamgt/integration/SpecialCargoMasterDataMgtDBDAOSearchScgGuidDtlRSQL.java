/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOSearchScgGuidDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.23
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.10.23 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOSearchScgGuidDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchScgGuidDtl
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOSearchScgGuidDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subject",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOSearchScgGuidDtlRSQL").append("\n"); 
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
		query.append("SELECT  SPCL_CGO_GUID_CD AS SPCL_CGO_GUID_CD" ).append("\n"); 
		query.append(",SPCL_CGO_GUID_SEQ AS SPCL_CGO_GUID_SEQ" ).append("\n"); 
		query.append(",HDR_CTNT AS HDR_CTNT" ).append("\n"); 
		query.append(",FTR_CTNT AS FTR_CTNT" ).append("\n"); 
		query.append(",CRE_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT AS CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID AS UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("FROM    SCG_GUID_DTL" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     SPCL_CGO_GUID_CD = @[scg_flg]" ).append("\n"); 
		query.append("#if (${subject_cd} == 'S')" ).append("\n"); 
		query.append("AND     UPPER(HDR_CTNT) LIKE UPPER('%' || @[subject] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subject_cd} == 'W')" ).append("\n"); 
		query.append("AND     UPPER(FTR_CTNT) LIKE UPPER('%' || @[subject] || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY NLSSORT(HDR_CTNT, 'NLS_SORT = GENERIC_M_CI' ), SPCL_CGO_GUID_SEQ" ).append("\n"); 

	}
}