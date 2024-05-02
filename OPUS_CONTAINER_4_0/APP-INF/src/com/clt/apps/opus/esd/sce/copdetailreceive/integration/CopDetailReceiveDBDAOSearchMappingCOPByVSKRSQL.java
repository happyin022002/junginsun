/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchMappingCOPByVSKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.04 
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

public class CopDetailReceiveDBDAOSearchMappingCOPByVSKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMappingCOPByVSK
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchMappingCOPByVSKRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchMappingCOPByVSKRSQL").append("\n"); 
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
		query.append("select decode(pre_cop,null,'',substr(pre_cop,1,14)) pre_cop_no" ).append("\n"); 
		query.append(",decode(pre_cop,null,'',substr(pre_cop,15,4)) pre_cop_dtl_seq" ).append("\n"); 
		query.append(",decode(nxt_cop,null,'',substr(nxt_cop,1,14)) nxt_cop_no" ).append("\n"); 
		query.append(",decode(nxt_cop,null,'',substr(nxt_cop,15,4)) nxt_cop_dtl_seq" ).append("\n"); 
		query.append(", cop_no, to_char(cop_dtl_seq) cop_dtl_seq, act_sts_cd, to_char(act_dt,'YYYY/MM/DD HH24:MI:SS') act_dt, act_cd" ).append("\n"); 
		query.append(", bkg_no, cntr_no, mst_cop_no, cop_sts_cd" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select pre_cop, nxt_cop, cop_no, cop_dtl_seq, act_sts_cd, act_cd, act_dt, bkg_no, cntr_no, mst_cop_no, cop_sts_cd" ).append("\n"); 
		query.append("from (  select decode(d.cop_no||d.cop_dtl_seq,f.cop_no||f.cop_dtl_seq,'Y','N') fnd_flg" ).append("\n"); 
		query.append(",lag(d.cop_no||d.cop_dtl_seq, 1, 'X') over (order by d.cop_no,d.cop_dtl_seq) as pre_cop" ).append("\n"); 
		query.append(",lead(d.cop_no||d.cop_dtl_seq, 1, 'X') over (order by d.cop_no,d.cop_dtl_seq) as nxt_cop" ).append("\n"); 
		query.append(",h.bkg_no,h.cntr_no,h.mst_cop_no,h.cop_sts_cd" ).append("\n"); 
		query.append(",d.*" ).append("\n"); 
		query.append("from   sce_cop_dtl f, sce_cop_hdr h, sce_cop_dtl d" ).append("\n"); 
		query.append("where  f.vsl_cd                 = @[vsl_cd]" ).append("\n"); 
		query.append("and    f.skd_voy_no             = @[skd_voy_no]" ).append("\n"); 
		query.append("and    f.skd_dir_cd             = @[skd_dir_cd]" ).append("\n"); 
		query.append("and    substr(f.act_cd,5,1)     = substr(@[act_sts_mapg_cd],3,1)" ).append("\n"); 
		query.append("and    f.vps_port_cd            = @[vps_port_cd]" ).append("\n"); 
		query.append("and    nvl(f.clpt_ind_seq, '1') = @[clpt_ind_seq]" ).append("\n"); 
		query.append("and    h.cop_no                 = f.cop_no" ).append("\n"); 
		query.append("and    h.cop_sts_cd             IN ('C','T',decode(@[cop_no],null,'T','F'))" ).append("\n"); 
		query.append("and    h.cntr_no                <> 'COMU0000000'" ).append("\n"); 
		query.append("and    h.cop_no                 = decode(@[cop_no],null,h.cop_no,@[cop_no])" ).append("\n"); 
		query.append("and    h.bkg_no                 = decode(@[bkg_no],null,h.bkg_no,@[bkg_no])" ).append("\n"); 
		query.append("and    h.cntr_no                = decode(@[cntr_no],null,h.cntr_no,@[cntr_no])" ).append("\n"); 
		query.append("and    d.cop_no                 = f.cop_no" ).append("\n"); 
		query.append("and    d.cop_no                 = h.cop_no" ).append("\n"); 
		query.append(") s" ).append("\n"); 
		query.append("where s.fnd_flg = 'Y'" ).append("\n"); 
		query.append("group by pre_cop, nxt_cop, cop_no, cop_dtl_seq, act_sts_cd, act_cd, act_dt, bkg_no, cntr_no, mst_cop_no, cop_sts_cd) x" ).append("\n"); 

	}
}