/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendExptTsBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.15 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOsearchUsWhfSendExptTsBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfSendExptTsBkgNo
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfSendExptTsBkgNoRSQL(){
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendExptTsBkgNoRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT B.BKG_NO" ).append("\n"); 
		query.append("              ,ROW_NUMBER() OVER(PARTITION BY B.BKG_NO ORDER BY B.BKG_NO) AS RNUM" ).append("\n"); 
		query.append("          FROM BKG_USA_WHF_CNTR A" ).append("\n"); 
		query.append("              ,BKG_BOOKING B" ).append("\n"); 
		query.append("         WHERE A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("           AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("           AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("           AND (A.USA_WHF_EXPT_FLG = 'Y' OR A.USA_WHF_TRSP_TP_CD = 'T')" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE RNUM = 1" ).append("\n"); 

	}
}