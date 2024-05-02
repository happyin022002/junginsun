/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCopDetailBySPPRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.10 김성일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungil Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchCopDetailBySPPRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopDetailBySPP
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCopDetailBySPPRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCopDetailBySPPRSQL").append("\n"); 
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
		query.append("SELECT  dtl.cop_no as cop_no," ).append("\n"); 
		query.append("dtl.cop_dtl_seq as cop_dtl_seq," ).append("\n"); 
		query.append("dtl.act_sts_cd as act_sts_cd," ).append("\n"); 
		query.append("dtl.nod_cd as nod_cd," ).append("\n"); 
		query.append("vsl_cd," ).append("\n"); 
		query.append("skd_voy_no," ).append("\n"); 
		query.append("skd_dir_cd," ).append("\n"); 
		query.append("stnd_edi_sts_cd" ).append("\n"); 
		query.append("FROM SCE_COP_DTL dtl," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT cop_no" ).append("\n"); 
		query.append("FROM   SCE_COP_HDR" ).append("\n"); 
		query.append("WHERE   cntr_no = @[p_cntr_no]" ).append("\n"); 
		query.append("and     bkg_no = @[p_bkg_no]" ).append("\n"); 
		query.append("AND     cop_sts_cd IN('C', 'T', 'F')" ).append("\n"); 
		query.append(") cntr" ).append("\n"); 
		query.append("WHERE   dtl.cop_no = cntr.cop_no" ).append("\n"); 
		query.append("AND     dtl.act_cd = @[p_act_cd]" ).append("\n"); 
		query.append("AND     ROWNUM     = 1" ).append("\n"); 

	}
}