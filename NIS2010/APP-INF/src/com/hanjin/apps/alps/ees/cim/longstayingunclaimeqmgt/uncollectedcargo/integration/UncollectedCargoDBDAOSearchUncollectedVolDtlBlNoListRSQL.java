/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOSearchUncollectedVolDtlBlNoListRSQL.java
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

public class UncollectedCargoDBDAOSearchUncollectedVolDtlBlNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UC-VOL_DTL BlNo로 조회 
	  * </pre>
	  */
	public UncollectedCargoDBDAOSearchUncollectedVolDtlBlNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOSearchUncollectedVolDtlBlNoListRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(CNTR.CNTR_NO,UC.CNTR_NO,'1','0') AS SEL" ).append("\n"); 
		query.append("        , CNTR.BL_NO" ).append("\n"); 
		query.append("        , CNTR.CNTR_NO" ).append("\n"); 
		query.append("        , CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , '' AS VOL_DTL_GB" ).append("\n"); 
		query.append("		, '' AS UC_CS_NO" ).append("\n"); 
		query.append("FROM    (SELECT  B.BKG_NO" ).append("\n"); 
		query.append("                , B.BL_NO" ).append("\n"); 
		query.append("                , C.CNTR_NO" ).append("\n"); 
		query.append("                , C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        FROM BKG_BOOKING B" ).append("\n"); 
		query.append("            , BKG_CONTAINER C" ).append("\n"); 
		query.append("        WHERE B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("        AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("        ) CNTR" ).append("\n"); 
		query.append("        , (SELECT BL_NO, CNTR_NO " ).append("\n"); 
		query.append("        FROM CIM_UC_CGO_CNTR " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND UC_CS_NO = @[uc_cs_no]" ).append("\n"); 
		query.append("        AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("        ) UC" ).append("\n"); 
		query.append("WHERE CNTR.BL_NO = UC.BL_NO(+)" ).append("\n"); 
		query.append("AND CNTR.CNTR_NO  = UC.CNTR_NO(+)" ).append("\n"); 
		query.append("ORDER BY 1 DESC" ).append("\n"); 

	}
}