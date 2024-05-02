/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchCopDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchCopDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCopDetail
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchCopDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchCopDetailRSQL").append("\n"); 
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
		query.append("SELECT d.act_cd" ).append("\n"); 
		query.append(",d.nod_cd" ).append("\n"); 
		query.append(",d.act_sts_mapg_cd" ).append("\n"); 
		query.append(",d.stnd_edi_sts_cd" ).append("\n"); 
		query.append(",d.vsl_cd" ).append("\n"); 
		query.append(",d.skd_voy_no" ).append("\n"); 
		query.append(",d.skd_dir_cd" ).append("\n"); 
		query.append(",TO_CHAR(d.act_dt,'YYYYMMDDHH24MISS') act_dt" ).append("\n"); 
		query.append(",(TO_CHAR((TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS') - estm_dt),'0.0000000000')) act_gap_desc" ).append("\n"); 
		query.append(",h.bkg_no" ).append("\n"); 
		query.append(",h.cntr_no" ).append("\n"); 
		query.append(",h.mst_cop_no" ).append("\n"); 
		query.append("FROM sce_cop_dtl d, sce_cop_hdr h" ).append("\n"); 
		query.append("WHERE d.cop_no = @[cop_no]" ).append("\n"); 
		query.append("AND   d.cop_dtl_seq = @[cop_dtl_seq]" ).append("\n"); 
		query.append("AND   d.act_cd = 'FITZAD'" ).append("\n"); 
		query.append("and   h.cop_no = d.cop_no" ).append("\n"); 
		query.append("and   h.cop_sts_cd <> 'X'" ).append("\n"); 

	}
}