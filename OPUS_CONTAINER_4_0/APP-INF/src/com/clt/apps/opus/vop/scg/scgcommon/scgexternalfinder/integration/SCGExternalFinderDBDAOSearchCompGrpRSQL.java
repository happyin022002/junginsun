/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGExternalFinderDBDAOSearchCompGrpRSQL.java
*@FileTitle : VSL OPR's Restriction on DG (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.09 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOSearchCompGrpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public SCGExternalFinderDBDAOSearchCompGrpRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_comp_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("A.IMDG_COMP_GRP_CD   ," ).append("\n"); 
		query.append("A.IMDG_COMP_GRP_DESC ," ).append("\n"); 
		query.append("A.DELT_FLG ," ).append("\n"); 
		query.append("A.CRE_USR_ID ," ).append("\n"); 
		query.append("A.CRE_DT ," ).append("\n"); 
		query.append("A.UPD_USR_ID ," ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append("FROM  SCG_IMDG_COMP_GRP A" ).append("\n"); 
		query.append("WHERE  A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${imdg_comp_grp_cd} != '')" ).append("\n"); 
		query.append("AND  A.IMDG_COMP_GRP_CD = @[imdg_comp_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.scgexternalfinder").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOSearchCompGrpRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}