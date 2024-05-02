/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchVSLMappingCopRSQL.java
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

public class CopDetailReceiveDBDAOSearchVSLMappingCopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVSLMappingCop
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchVSLMappingCopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_cop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_vsl_cd_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchVSLMappingCopRSQL").append("\n"); 
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
		query.append("SELECT PRE_COP, NXT_COP, COP_NO, COP_DTL_SEQ, ACT_STS_CD, ACT_CD, ACT_DT" ).append("\n"); 
		query.append("FROM (  SELECT DECODE(D.COP_NO||D.COP_DTL_SEQ,F.COP_NO||F.COP_DTL_SEQ,'Y','N') FND_FLG" ).append("\n"); 
		query.append("        ,LAG(D.COP_NO||D.COP_DTL_SEQ, 1, 'X') OVER (ORDER BY D.COP_NO,D.COP_DTL_SEQ) AS PRE_COP" ).append("\n"); 
		query.append("        ,LEAD(D.COP_NO||D.COP_DTL_SEQ, 1, 'X') OVER (ORDER BY D.COP_NO,D.COP_DTL_SEQ) AS NXT_COP" ).append("\n"); 
		query.append("        ,D.*" ).append("\n"); 
		query.append("        FROM   SCE_COP_DTL F, SCE_COP_HDR H, SCE_COP_DTL D " ).append("\n"); 
		query.append("        WHERE  F.VSL_CD                 = @[in_vsl_cd_CD]  " ).append("\n"); 
		query.append("        AND    F.SKD_VOY_NO             = @[in_skd_voy_no]         " ).append("\n"); 
		query.append("        AND    F.SKD_DIR_CD             = @[in_skd_dir_cd]  " ).append("\n"); 
		query.append("        AND    SUBSTR(F.ACT_CD,5,1)     = @[in_act_sts_mapg_cd]     " ).append("\n"); 
		query.append("        AND    F.VPS_PORT_CD            = @[in_vps_port_cd]" ).append("\n"); 
		query.append("        AND    NVL(F.CLPT_IND_SEQ, '1') = @[in_clpt_ind_seq]" ).append("\n"); 
		query.append("        AND    H.COP_NO                 = F.COP_NO" ).append("\n"); 
		query.append("        AND    H.COP_STS_CD             IN ('C','T')" ).append("\n"); 
		query.append("        AND    H.CNTR_NO                <> 'SMCU0000000'" ).append("\n"); 
		query.append("        AND    H.COP_NO                 = DECODE(@[in_cop_no],NULL,H.COP_NO,@[in_cop_no])" ).append("\n"); 
		query.append("        AND    H.BKG_NO                 = DECODE(@[in_bkg_no],NULL,H.BKG_NO,@[in_bkg_no])" ).append("\n"); 
		query.append("        AND    H.CNTR_NO                = DECODE(@[in_cntr_no],NULL,H.CNTR_NO,@[in_cntr_no])                " ).append("\n"); 
		query.append("        AND    D.COP_NO                 = F.COP_NO  " ).append("\n"); 
		query.append("        AND    D.COP_NO                 = H.COP_NO ) S" ).append("\n"); 
		query.append("WHERE S.FND_FLG = 'Y'" ).append("\n"); 
		query.append("GROUP BY PRE_COP, NXT_COP, COP_NO, COP_DTL_SEQ, ACT_STS_CD, ACT_CD, ACT_DT" ).append("\n"); 

	}
}