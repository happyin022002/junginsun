/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Edi315SendDBDAOSearchCurrVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchCurrVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCurrVvd
	  * </pre>
	  */
	public Edi315SendDBDAOSearchCurrVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchCurrVvdRSQL").append("\n"); 
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
		query.append("SELECT    D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD CURR_VVD" ).append("\n"); 
		query.append("            , BOUND" ).append("\n"); 
		query.append("            , D.COP_DTL_SEQ   CURR_DTL_SEQ" ).append("\n"); 
		query.append("            , replace(mv.vsl_eng_nm, chr(39), ' ')                      vsl_nm  " ).append("\n"); 
		query.append("            , mv.vsl_rgst_cnt_cd                                        vsl_cnt_cd  " ).append("\n"); 
		query.append("            , nvl(decode(mv.LLOYD_NO, 'T.B.N.', 'TBN', 'T.B.N', 'TBN', LLOYD_NO), ' ')  lloyd_cd" ).append("\n"); 
		query.append("    FROM sce_cop_dtl D,MDM_VSL_CNTR MV," ).append("\n"); 
		query.append("        (   " ).append("\n"); 
		query.append("            SELECT case when EDI_STS_SEQ <= 200  or  @[edi_sts] in ('BF', 'AW', 'AMO') then 'OB'   " ).append("\n"); 
		query.append("                        when (200 < EDI_STS_SEQ and EDI_STS_SEQ < 300 and  @[edi_sts] <> 'VE') or  @[edi_sts] in ('UVD') then 'OC'   " ).append("\n"); 
		query.append("                        when (300 <= EDI_STS_SEQ and  @[edi_sts] not in ('BF', 'AW', 'AMO', 'UVD')) or  @[edi_sts] = 'VE' then 'IB'   " ).append("\n"); 
		query.append("                END BOUND         " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("            from EDI_CGO_STND_STS   " ).append("\n"); 
		query.append("            where EDI_STND_STS_CD =  @[edi_sts]" ).append("\n"); 
		query.append("        )   " ).append("\n"); 
		query.append("    where cop_no  = @[cop_no]" ).append("\n"); 
		query.append("    and (   " ).append("\n"); 
		query.append("            ('OB' = BOUND and STND_EDI_STS_CD = 'AEL')   -- OBWD운송 시 act_cd like 'FL%' 조건으로 안되서 AEL 로 변경 . YJLEE 100409" ).append("\n"); 
		query.append("            or   " ).append("\n"); 
		query.append("            ('OC' = BOUND and nod_cd like  substr(@[org_nod],1,5)||'%' and STND_EDI_STS_CD like decode( @[edi_sts], 'VE', 'VAD', 'VDE', 'VDL', 'VET', 'VDT', 'VETS', 'VAT', @[edi_sts]||'%'))   " ).append("\n"); 
		query.append("            or   " ).append("\n"); 
		query.append("            ('IB' = BOUND and act_cd like 'FU%')   " ).append("\n"); 
		query.append("        )    " ).append("\n"); 
		query.append("    AND MV.VSL_CD(+) = D.VSL_CD" ).append("\n"); 
		query.append("    and rownum = 1" ).append("\n"); 

	}
}