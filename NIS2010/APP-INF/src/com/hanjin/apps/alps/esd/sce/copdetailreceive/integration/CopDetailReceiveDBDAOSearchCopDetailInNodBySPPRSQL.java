/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCopDetailInNodBySPPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.18 김성일
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

public class CopDetailReceiveDBDAOSearchCopDetailInNodBySPPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopDetailInNodBySPP
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCopDetailInNodBySPPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCopDetailInNodBySPPRSQL").append("\n"); 
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
		query.append("SELECT  DTL.cop_no as cop_no," ).append("\n"); 
		query.append("DTL.cop_dtl_seq as cop_dtl_seq," ).append("\n"); 
		query.append("DTL.act_sts_cd as act_sts_cd," ).append("\n"); 
		query.append("DTL.vsl_cd," ).append("\n"); 
		query.append("DTL.skd_voy_no," ).append("\n"); 
		query.append("DTL.skd_dir_cd," ).append("\n"); 
		query.append("DTL.stnd_edi_sts_cd" ).append("\n"); 
		query.append("FROM SCE_COP_DTL DTL," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT cop_no" ).append("\n"); 
		query.append("FROM   SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE  cntr_no = @[in_cntr_no]" ).append("\n"); 
		query.append("and     bkg_no = @[in_bkg_no]" ).append("\n"); 
		query.append("AND     cop_sts_cd IN ('C', 'T', 'F')" ).append("\n"); 
		query.append(") cntr" ).append("\n"); 
		query.append("WHERE DTL.cop_no = cntr.cop_no" ).append("\n"); 
		query.append("#if (${in_act_cd} != '')" ).append("\n"); 
		query.append("AND DTL.act_cd = @[in_act_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DTL.nod_cd = @[in_nod_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}