/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerSpecMgtDBDAOSearchCntrSpecUsingCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.12.23 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSpecMgtDBDAOSearchCntrSpecUsingCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제하기전에 삭제할수 있는지 체크한다.
	  * </pre>
	  */
	public ContainerSpecMgtDBDAOSearchCntrSpecUsingCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_spec_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.integration").append("\n"); 
		query.append("FileName : ContainerSpecMgtDBDAOSearchCntrSpecUsingCheckRSQL").append("\n"); 
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
		query.append("#if (${own_cntr_flg} == 'N')" ).append("\n"); 
		query.append("SELECT A.AGMT_CTY_CD || LPAD(A.AGMT_SEQ,6,'0') AS AGMT" ).append("\n"); 
		query.append("FROM LSE_AGMT_RT A" ).append("\n"); 
		query.append("WHERE A.CNTR_SPEC_NO = @[cntr_spec_no]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${own_cntr_flg} == 'Y')" ).append("\n"); 
		query.append("SELECT A.LOT_PLN_YR||'-'|| A.LOT_LOC_CD||'-'|| A.CNTR_TPSZ_CD||'-'|| LTRIM(TO_CHAR(A.LOT_SEQ,'000'))  AS AGMT" ).append("\n"); 
		query.append("FROM MST_CNTR_LOT A" ).append("\n"); 
		query.append("WHERE A.CNTR_SPEC_NO = @[cntr_spec_no]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}