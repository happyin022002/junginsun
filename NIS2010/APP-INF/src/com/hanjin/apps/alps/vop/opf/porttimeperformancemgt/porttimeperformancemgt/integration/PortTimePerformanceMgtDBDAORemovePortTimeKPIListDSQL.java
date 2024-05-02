/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAORemovePortTimeKPIListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.07.10 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAORemovePortTimeKPIListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 KPI 정보를 삭제 한다.
	  * History------------------------------------------------------------------------------------
	  * 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
	  * 2012.07.09 문동선 [CHM-201218855-01] Base line 입력화면 추가
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAORemovePortTimeKPIListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_tgt_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAORemovePortTimeKPIListDSQL").append("\n"); 
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
		query.append("#if(${tab_chk}=='KPI'||${tab_chk}=='')" ).append("\n"); 
		query.append("DELETE FROM OPF_PORT_TM_KPI" ).append("\n"); 
		query.append("WHERE   KPI_TGT_YR      = @[kpi_tgt_yr]" ).append("\n"); 
		query.append("AND     KPI_VER_SEQ     = @[kpi_ver_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${tab_chk}=='BSEL')" ).append("\n"); 
		query.append("DELETE FROM OPF_PORT_TM_BSEL" ).append("\n"); 
		query.append("WHERE   BSEL_YR      = @[kpi_tgt_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}