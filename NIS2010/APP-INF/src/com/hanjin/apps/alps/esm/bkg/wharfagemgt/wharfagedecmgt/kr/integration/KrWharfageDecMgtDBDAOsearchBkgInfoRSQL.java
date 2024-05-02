/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOsearchBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.30
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.04.30 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOsearchBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * s
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOsearchBkgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amount",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOsearchBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("DECODE(sign(@[amount]),-1,'N',DECODE(SUBSTR(@[whf_bnd_cd],1,1)," ).append("\n"); 
		query.append("'I',DECODE(SUBSTR(POD_CD,1,2),'KR',DECODE(@[port_cd], 'KRPUS',DECODE(POD_CD,'KRKAN','T','KRINC','T','KRPTK','T','N')," ).append("\n"); 
		query.append("'KRKAN',DECODE(POD_CD,'KRPUS','T','KRINC','T','KRPTK','T','N')," ).append("\n"); 
		query.append("'KRINC',DECODE(POD_CD,'KRPUS','T','KRKAN','T','KRPTK','T','N')," ).append("\n"); 
		query.append("'KRGIN',DECODE(POD_CD,'KRPUS','T','KRKAN','T','KRPTK','T','N')," ).append("\n"); 
		query.append("'KRPTK',DECODE(POD_CD,'KRPUS','T','KRKAN','T','KRINC','T','N')," ).append("\n"); 
		query.append("'N')," ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'O',DECODE(SUBSTR(POL_CD,1,2),'KR',DECODE(@[port_cd],'KRPUS',DECODE(POL_CD,'KRKAN','T','KRINC','T','KRPTK','T','N')," ).append("\n"); 
		query.append("'KRKAN',DECODE(POL_CD,'KRPUS','T','KRINC','T','KRPTK','T','N')," ).append("\n"); 
		query.append("'KRINC',DECODE(POL_CD,'KRPUS','T','KRKAN','T','KRPTK','T','N')," ).append("\n"); 
		query.append("'KRGIN',DECODE(POL_CD,'KRPUS','T','KRKAN','T','KRPTK','T','N')," ).append("\n"); 
		query.append("'KRPTK',DECODE(POL_CD,'KRPUS','T','KRKAN','T','KRINC','T','N')," ).append("\n"); 
		query.append("'N')," ).append("\n"); 
		query.append("'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")) WHF_BL_THRU_TS_FLG," ).append("\n"); 
		query.append("BKG_CGO_TP_CD," ).append("\n"); 
		query.append("OB_SLS_OFC_CD," ).append("\n"); 
		query.append("SLAN_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}