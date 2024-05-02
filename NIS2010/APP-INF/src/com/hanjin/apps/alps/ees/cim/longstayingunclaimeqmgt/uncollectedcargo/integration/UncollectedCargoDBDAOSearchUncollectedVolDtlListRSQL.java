/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOSearchUncollectedVolDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOSearchUncollectedVolDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UC-VOL_DTL 조회 
	  * </pre>
	  */
	public UncollectedCargoDBDAOSearchUncollectedVolDtlListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOSearchUncollectedVolDtlListRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(C.CNTR_NO,U.CNTR_NO,'1','0') AS SEL" ).append("\n"); 
		query.append("        , U.UC_CS_NO" ).append("\n"); 
		query.append("        , B.BKG_NO" ).append("\n"); 
		query.append("        , B.BL_NO" ).append("\n"); 
		query.append("        , C.CNTR_NO" ).append("\n"); 
		query.append("        , C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, '' AS VOL_DTL_GB" ).append("\n"); 
		query.append("FROM BKG_BOOKING B" ).append("\n"); 
		query.append("    , BKG_CONTAINER C" ).append("\n"); 
		query.append("    , CIM_UC_CGO_CNTR U" ).append("\n"); 
		query.append("WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND B.BL_NO  = U.BL_NO" ).append("\n"); 
		query.append("	AND C.CNTR_NO  = U.CNTR_NO" ).append("\n"); 
		query.append("	AND U.UC_CS_NO = @[uc_cs_no]" ).append("\n"); 
		query.append("ORDER BY U.CNTR_NO" ).append("\n"); 

	}
}