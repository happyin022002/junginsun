/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCopVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchCopVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopVVD
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCopVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration ").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCopVVDRSQL").append("\n"); 
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
		query.append("select  dtl.cop_no," ).append("\n"); 
		query.append("dtl.cop_dtl_seq," ).append("\n"); 
		query.append("dtl.act_sts_cd," ).append("\n"); 
		query.append("dtl.vsl_cd," ).append("\n"); 
		query.append("dtl.skd_voy_no," ).append("\n"); 
		query.append("dtl.skd_dir_cd," ).append("\n"); 
		query.append("dtl.stnd_edi_sts_cd" ).append("\n"); 
		query.append("from sce_cop_dtl dtl," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select cop_no" ).append("\n"); 
		query.append("from   sce_cop_hdr" ).append("\n"); 
		query.append("where  cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("and     bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and     cop_sts_cd in ('C', 'T', 'F')" ).append("\n"); 
		query.append(") cntr" ).append("\n"); 
		query.append("where dtl.cop_no = cntr.cop_no" ).append("\n"); 
		query.append("and dtl.act_cd = @[act_cd]" ).append("\n"); 
		query.append("and dtl.nod_cd = nvl(@[nod_cd],dtl.nod_cd)" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 

	}
}