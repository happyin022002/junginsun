/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchVSLDetailInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.19 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchVSLDetailInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVSLDetailInfo
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchVSLDetailInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_act_sts_mapg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchVSLDetailInfoRSQL").append("\n"); 
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
		query.append("SELECT c.cop_no" ).append("\n"); 
		query.append("        ,c.cop_dtl_seq" ).append("\n"); 
		query.append("        ,d.bkg_no" ).append("\n"); 
		query.append("        ,d.cntr_no" ).append("\n"); 
		query.append("        ,c.nod_cd" ).append("\n"); 
		query.append("        ,m.act_stnd_edi_sts_cd" ).append("\n"); 
		query.append("    FROM    sce_cop_dtl c" ).append("\n"); 
		query.append("            ,sce_cop_hdr d" ).append("\n"); 
		query.append("            ,mdm_activity m" ).append("\n"); 
		query.append("    WHERE  c.vsl_cd      = @[in_vsl_cd]" ).append("\n"); 
		query.append("        AND    c.skd_voy_no  = @[in_skd_voy_no]" ).append("\n"); 
		query.append("        AND    c.skd_dir_cd  = @[in_skd_dir_cd]" ).append("\n"); 
		query.append("        AND    c.vps_port_cd = @[in_vps_port_cd]" ).append("\n"); 
		query.append("        AND    d.cop_no      = c.cop_no" ).append("\n"); 
		query.append("        AND    c.act_cd      = m.act_cd" ).append("\n"); 
		query.append("        AND    c.act_sts_cd  = 'F'" ).append("\n"); 
		query.append("        AND    d.cntr_no    <> 'SMCU0000000'" ).append("\n"); 
		query.append("        AND    d.cop_sts_cd  in ('C','T')" ).append("\n"); 
		query.append("        and    d.cop_no                 = decode(@[cop_no],null,d.cop_no,@[cop_no])" ).append("\n"); 
		query.append("        and    d.bkg_no                 = decode(@[bkg_no],null,d.bkg_no,@[bkg_no])" ).append("\n"); 
		query.append("        and    d.cntr_no                = decode(@[cntr_no],null,d.cntr_no,@[cntr_no])    " ).append("\n"); 
		query.append("        AND    substr(c.act_cd,5,1) =" ).append("\n"); 
		query.append("            (CASE" ).append("\n"); 
		query.append("                WHEN @[in_act_sts_mapg_cd] = 'ATD'" ).append("\n"); 
		query.append("                THEN 'D'" ).append("\n"); 
		query.append("                WHEN @[in_act_sts_mapg_cd] = 'ATA'" ).append("\n"); 
		query.append("                THEN 'A'" ).append("\n"); 
		query.append("            END)" ).append("\n"); 

	}
}