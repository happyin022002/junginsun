/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOaddBkgUsaWhfSndInitCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOaddBkgUsaWhfSndInitCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBkgUsaWhfSndInit
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOaddBkgUsaWhfSndInitCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOaddBkgUsaWhfSndInitCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_USA_WHF_SND (" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	PORT_CD" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	VSL_NM" ).append("\n"); 
		query.append(",	CRR_CD" ).append("\n"); 
		query.append(",	VSL_VOY_DIR_NO" ).append("\n"); 
		query.append(",	BRTH_DESC" ).append("\n"); 
		query.append(",	DEP_DT" ).append("\n"); 
		query.append(",	ARR_DT" ).append("\n"); 
		query.append(",	BIL_RCV_PTY_NM" ).append("\n"); 
		query.append(",	BIL_SND_PTY_NM" ).append("\n"); 
		query.append(",	SND_RMK" ).append("\n"); 
		query.append(",	WHF_DC_RT" ).append("\n"); 
		query.append(",	DDCT_AMT" ).append("\n"); 
		query.append(",	LOCL_UPD_DT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT /*+ INDEX_DESC(D XPKBKG_USA_WHF_EML) */" ).append("\n"); 
		query.append("           @[vsl_cd]" ).append("\n"); 
		query.append("          ,@[skd_voy_no]" ).append("\n"); 
		query.append("          ,@[skd_dir_cd]" ).append("\n"); 
		query.append("          ,@[port_cd]" ).append("\n"); 
		query.append("          ,@[io_bnd_cd]" ).append("\n"); 
		query.append("          ,B.VSL_ENG_NM" ).append("\n"); 
		query.append("          ,B.CRR_CD" ).append("\n"); 
		query.append("          ,@[skd_voy_no] || @[skd_dir_cd]" ).append("\n"); 
		query.append("--          ,D.BRTH_DESC" ).append("\n"); 
		query.append("		  ,DECODE(D.BRTH_DESC, NULL, DECODE( B.CRR_CD, 'SML', 'T-136', 'COS', '246-247', '234'), D.BRTH_DESC) " ).append("\n"); 
		query.append("          ,C.VPS_ETD_DT" ).append("\n"); 
		query.append("          ,C.VPS_ETA_DT" ).append("\n"); 
		query.append("--          ,D.BIL_RCV_PTY_NM" ).append("\n"); 
		query.append("          ,CASE B.CRR_CD WHEN 'SML' THEN 'TTI'" ).append("\n"); 
		query.append("                         WHEN 'COS' THEN 'PCT'" ).append("\n"); 
		query.append("                         ELSE 'ITS'" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("		  ,'SM LINE'	" ).append("\n"); 
		query.append("          ,NULL" ).append("\n"); 
		query.append("          ,E.WHF_DC_RT" ).append("\n"); 
		query.append("          ,0" ).append("\n"); 
		query.append("          ,SYSDATE" ).append("\n"); 
		query.append("          ,@[cre_usr_id]" ).append("\n"); 
		query.append("          ,@[cre_usr_id]" ).append("\n"); 
		query.append("      FROM MDM_VSL_CNTR B" ).append("\n"); 
		query.append("          ,VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("          ,BKG_USA_WHF_EML D" ).append("\n"); 
		query.append("          ,(" ).append("\n"); 
		query.append("            SELECT MAX(WHF_DC_RT) AS WHF_DC_RT" ).append("\n"); 
		query.append("              FROM BKG_USA_WHF_RT" ).append("\n"); 
		query.append("             WHERE EFF_DT = (SELECT MAX(EFF_DT) FROM BKG_USA_WHF_RT WHERE PORT_CD = @[port_cd] AND IO_BND_CD = @[io_bnd_cd])" ).append("\n"); 
		query.append("               AND PORT_CD = @[port_cd] " ).append("\n"); 
		query.append("               AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("		   ) E" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND B.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("       AND C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("       AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("       AND C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("       AND C.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("       AND C.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("       AND C.VPS_PORT_CD = D.PORT_CD(+)" ).append("\n"); 
		query.append("       AND C.YD_CD       = D.YD_CD(+)" ).append("\n"); 
		query.append("       AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}